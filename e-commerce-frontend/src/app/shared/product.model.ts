import {Details} from "./product-details.model";

export interface ProductModel {
  document_id: string
  name: string;
  price: number;
  img: string;
  brand: string;
  category: string;
  rating: number;
  details: Details[];
}
