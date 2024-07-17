import { Injectable } from "@angular/core";
import { Actions, createEffect, ofType } from "@ngrx/effects";
import { fetchProducts, fetchProductsFailure, fetchProductsSuccess } from "./product.action";
import { catchError, map, Observable, of, switchMap, tap } from "rxjs";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { ProductModel } from "../../shared/product.model";
import { AuthService } from "../../services/auth.service";
import { UserModel } from "../../shared/user.model";

@Injectable()
export class ProductEffect {

  productForCategory: ProductModel[];


  constructor(private actions$: Actions,
    private http: HttpClient,
    private authService: AuthService
  ) {
    this.productForCategory = [];
  }


  fetchProductsEffect$ = createEffect(() => this.actions$.pipe(
    ofType(fetchProducts),
    switchMap((params) => {
      let userData = this.authService.getUserData();
      if(userData != null) {
        return this.fetchProducts(userData.authToken, params.category)
                  .pipe(map((productList: ProductModel[]) => {
                    console.log("Successfully fetched products...", productList);
                    return fetchProductsSuccess({ productList })
                  }),
                  catchError((error) => {
                    console.log("Error while fetching products...", error);
                    return of(fetchProductsFailure({ error }));
                  }));

      } else {
        return of(fetchProductsFailure({ error: 'User not authenticated' }));
      }

    })
  ));

  fetchProducts(authToken: string, category: string) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + authToken
    });

    return this.http.get<ProductModel[]>(`http://localhost:8081/products/mongo/${category}`, { headers });
  }


   

}