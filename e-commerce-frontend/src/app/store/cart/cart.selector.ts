import { createSelector } from "@ngrx/store";
import { AppState } from "../../app.module";
import { CartState } from "../state.selector";

const selectCartState = (state: AppState) => state.cart;


// Selector to select cart items
export const getCartItemsFromLocalStorage = createSelector(
  (state: { cart: CartState }) => state.cart,
  (cart: CartState) => {
    const cartList = localStorage.getItem('shoppingCartList');
    return cartList ? JSON.parse(cartList) : null;
  }

);

export const saveCartItemsInLocalStorage = createSelector(
  (state: { cart: CartState }) => state.cart,
  (cart: CartState) => cart.cartItems

);

export const selectCartItems = createSelector(
  (state: { cart: CartState }) => state.cart,
  (cart: CartState) => cart.cartItems
);