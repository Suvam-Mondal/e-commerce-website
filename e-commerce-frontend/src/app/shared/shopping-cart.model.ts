import {ProductModel} from "./product.model";

export interface ShoppingCartModel {
  product: ProductModel;
  quantity: number;
}
