import { createAction, props } from "@ngrx/store";
import { ProductModel } from "../../shared/product.model";
import { ShoppingCartModel } from "../../shared/shopping-cart.model";

export const addToCartAction = createAction("addToCart", props<{ product: ProductModel }>());
export const removeFromCartAction = createAction("removeFromCart", props<{ itemId: string }>());

export interface LoadCartItems {
    cartItems: ShoppingCartModel[];
  }
  
  export const loadCartItems = createAction('[Cart] Load Cart Items', props<{ cartItems: ShoppingCartModel[] }>());
  export const resetCartList = createAction('[Cart] Reset Cart Items');
