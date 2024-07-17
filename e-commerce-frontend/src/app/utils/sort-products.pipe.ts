import { Pipe, PipeTransform } from '@angular/core';
import { ProductModel } from "../shared/product.model";

@Pipe({
  name: 'sort',
  pure: false
})
export class SortProductsPipe implements PipeTransform {

  transform(value: ProductModel[], arg: string): ProductModel[] {
    try {
      if (arg === 'price') {
        return value.slice().sort((a, b) => a.price - b.price);
      } else if (arg === 'rating') {
        return value.slice().sort((a, b) => b.rating - a.rating);
      } else {
        return value;
      }
    } catch (error) {
      console.log("SortProductsPipe::Error transforming, returning default value...");
      return value;
    }
  }

}
