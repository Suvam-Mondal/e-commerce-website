import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Actions, createEffect, ofType } from "@ngrx/effects";
import { Action } from "@ngrx/store";
import { login, loginFailure, loginSuccess, logout } from "./auth.action";
import { catchError, concatMap, map, mergeMap, of, switchMap, tap } from "rxjs";
import { AuthService } from "../../services/auth.service";
import { UserModel } from "../../shared/user.model";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { AuthResponseModel } from "../../shared/authResponse.model";

@Injectable()
export class AuthEffect {

    constructor(private action$: Actions,
        private router: Router,
        private authService: AuthService,
        private http: HttpClient
    ) {

    }

    loginEffect$ = createEffect(() =>
        this.action$.pipe(
            ofType(login),
            switchMap((params) => {
                const userData = localStorage.getItem('userData');
                if (userData) {
                    return of(loginSuccess({ user: JSON.parse(userData).user }))
                } else {
                    return this.authService.getUserFromApi(params.auth, params.action).pipe(
                        map((response) => {
                          console.log("Successfully logged in...");
                          let u = new UserModel(params.auth.emailId, response.authToken, response.expiresIn);
                          localStorage.setItem('userData', JSON.stringify(u));
                          return loginSuccess({ user: u });
                        }),
                        catchError((error) => {
                          console.log("Error while logging in...", error);
                          return of(loginFailure({ error }));
                        })
                      );
                }
            }),
        )); //not setting dispatch to false as it is calling loginSuccess/ loginFailure

        loginSuccessEffect$ = createEffect(() =>
        this.action$.pipe(
            ofType(loginSuccess),
            tap((user) => {
                this.router.navigate(["/products/mobile"])
            }
        )), {dispatch: false});

    logoutEffect$ = createEffect(() =>
        this.action$.pipe(
            ofType(logout),
            tap(() => {
                console.log("logout Success ");
                this.clearLocalStorage();
                this.router.navigate(["/login"])
            })
        ),
        { dispatch: false }
    );


    clearLocalStorage() {
        localStorage.removeItem('userData');
        localStorage.removeItem('item');
        localStorage.removeItem('itemIndex');
        localStorage.removeItem('searchItemIndex');
        localStorage.removeItem('searchItemData');
        localStorage.removeItem('shoppingCartList');


    }



}