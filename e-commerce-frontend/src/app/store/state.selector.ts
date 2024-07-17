import { createSelector } from "@ngrx/store";
import { ProductModel } from "../shared/product.model";
import { ShoppingCartModel } from "../shared/shopping-cart.model";
import { UserModel } from "../shared/user.model";

export interface AuthState {
    isAuthenticated: boolean,
    authInfo: UserModel | null;
}

export interface ProductState {
    shouldDisplayAsList: boolean,
    sortItemsBy: string,
    productForCategory: ProductModel[]
}

export interface CartState {
    cartItems: ShoppingCartModel[]; // Replace 'any' with the actual type of your cart items
    // Add other fields managed by cartReducer if applicable
}


interface AppState {
    auth: AuthState;
    product: ProductState;
    cart: CartState;
}


export const initialProductState: ProductState = {
    shouldDisplayAsList: false,
    sortItemsBy: 'name',
    productForCategory: [],
};

export const initialAuthState: AuthState = {
    isAuthenticated: false,
    authInfo: null,
};
export const initialCartState: CartState = {
    cartItems: [],
};

export const appStateSelector = createSelector(
    (state: {appState: AppState})=>state.appState,
    (appState: AppState)=> appState
);

