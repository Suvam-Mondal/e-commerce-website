import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {Injectable} from "@angular/core";
import {AuthModel} from "../shared/auth.model";
import {filter, map, Observable, pipe, Subject, Subscription, take, tap} from "rxjs";
import {UserModel} from "../shared/user.model";
import {AuthResponseModel} from "../shared/authResponse.model";
import { select, Store } from "@ngrx/store";
import { login, loginFailure, loginSuccess, logout } from "../store/auth/auth.action";
import { AuthState } from "../store/state.selector";
import { userDataSelector } from "../store/auth/auth.selector";

@Injectable()
export class AuthService {

  isAuthenticated = new Subject<boolean>();
  user: UserModel;
  private authInfoSubscription: Subscription;

  constructor(private router: Router,
              private http: HttpClient,
              private store: Store<{authReducer: AuthState}>) {
  }

 
  onLogin(auth: AuthModel, action: string) {
    auth.role = "USER";
      this.store.dispatch(login({auth, action}));
  }


  onLogOut() {
    //save cartList if any
    //clear index and indexData
    this.store.dispatch(logout());
   // this.user = null;
   
  }


  isUserLoggedIn() {
    const userData = JSON.parse(localStorage.getItem('userData'));

    if (userData != null) {
      const u = new UserModel(userData.email, userData.authToken, userData.expiresIn);
      if (u.authToken) {
        return true;
      } else {
        return false;
      }
   }
  }

   autoLogin() {
    console.log("Auto login called");
    this.getUserData();
    if(this.user != null) {
      if (this.user.authToken) {
        this.autoLogout(this.user.expiresIn);
      }
    } else {
      this.router.navigate(["/login"]);
    }

  }

  autoLogout(expiresIn: Date) {
    let remainingTime = new Date(expiresIn).getTime() - new Date().getTime();
    setTimeout(() => {
      this.onLogOut();
    }, remainingTime);
  } 

  getUserFromApi(auth: any, action: any): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Action': action
      });
      return this.http.post<AuthResponseModel>("http://localhost:8081/auth",auth, {headers});
      
  }

  getUserData() {
    //get user data from store
    this.store.pipe(select(userDataSelector)).subscribe(data => {
      this.user = data;
    }); 

  return this.user;

  }



}
