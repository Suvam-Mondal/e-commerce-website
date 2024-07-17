import { Injectable } from "@angular/core";
import { Actions, createEffect, ofType } from "@ngrx/effects";
import { addToCartAction, removeFromCartAction, resetCartList } from "./cart.action";
import { pipe, tap } from "rxjs";
import { Store } from "@ngrx/store";
import { saveCartItemsInLocalStorage } from "./cart.selector";

@Injectable()
export class CartEffects {

    constructor(private actions$: Actions,
        private store: Store
    ){}

    cartUpdateEffect$ = createEffect(() => this.actions$.pipe(
        ofType(addToCartAction, removeFromCartAction, resetCartList),
        tap(() =>{ 
            this.store.select(saveCartItemsInLocalStorage).subscribe((cartItems) => {
                localStorage.setItem('shoppingCartList', JSON.stringify(cartItems));

            })
        })),
        
        {dispatch: false}
    );

}