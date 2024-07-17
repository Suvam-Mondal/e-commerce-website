import { createSelector } from "@ngrx/store";
import { productReducer } from "./product.reducer";
import { ProductState } from "../state.selector";

export const selectProductList = createSelector(
    (state: {product: ProductState})=>state.product,
    (product: ProductState) => product.productForCategory
);