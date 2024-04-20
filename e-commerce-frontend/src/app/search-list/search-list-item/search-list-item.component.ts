import {Component, Input} from '@angular/core';
import {ProductModel} from "../../shared/product.model";

@Component({
  selector: 'app-search-list-item',
  templateUrl: './search-list-item.component.html',
  styleUrl: './search-list-item.component.css'
})
export class SearchListItemComponent {
  @Input() itemIndex!: any;
  @Input() item!: ProductModel;

}
