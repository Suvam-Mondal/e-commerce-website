import { createAction, props } from "@ngrx/store";
import { ProductModel } from "../../shared/product.model";

export const fetchProducts = createAction("fetchProducts", props<{ category: string}>());
export const fetchProductsSuccess = createAction("fetchProductsSuccess", props<{ productList:  ProductModel[]}>());
export const fetchProductsFailure = createAction("fetchProductsFailure", props<{ error: string }>());
