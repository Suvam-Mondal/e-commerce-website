import { Pipe, PipeTransform } from '@angular/core';
import {ProductModel} from "../shared/product.model";

@Pipe({
  name: 'sort',
  pure: false
})
export class SortProductsPipe implements PipeTransform {

  transform(value: ProductModel[], arg: string): ProductModel[] {
    if (arg === 'price') {
      return value.slice().sort((a, b) => a.price - b.price);
    } else if (arg === 'rating') {
      return value; /*value.slice().sort((a, b) => b.rating - a.rating);*/
    } else {
      return value;
    }
  }

}
