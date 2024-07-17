import { createReducer, on, props } from "@ngrx/store";
import { initialProductState } from "../state.selector";
import { state } from "@angular/animations";
import { fetchProducts, fetchProductsSuccess } from "./product.action";

export const productReducer = createReducer(
    initialProductState,
    on(fetchProducts, (state, props) => {
        return {
            ...state,
            shouldDisplayAsList: true,
            sortItemsBy: props.category,
            productForCategory: null
        }
    }),
    on(fetchProductsSuccess, (state, {productList}) => {
        return {
            ...state,
            shouldDisplayAsList: true,
            productForCategory: productList
        }
    })
);


