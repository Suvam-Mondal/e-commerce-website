import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ProductModel} from "../../../shared/product.model";
import {ProductService} from "../../../services/product.service";

@Component({
  selector: 'app-product-list-item',
  templateUrl: './product-list-item.component.html',
  styleUrl: './product-list-item.component.css'
})
export class ProductListItemComponent implements OnInit{
  @Input() itemIndex: any;
  @Input() item!: ProductModel;
  @Output("selectedItem") selectedItem = new EventEmitter<ProductModel>(); // Output event to emit selected item

  ratingComponent: number = 0;

  constructor(private productService: ProductService) {
  }

  saveSelectedListItem() {
    //localStorage.setItem('itemIndex', JSON.stringify(this.itemIndex));
    //localStorage.setItem('item', JSON.stringify(this.item));
    this.selectedItem.emit(this.item);
  }

  ngOnInit(): void {
    const savedItemIndex = JSON.parse(localStorage.getItem('itemIndex'));
    const savedItem = JSON.parse(localStorage.getItem('item'));
    this.ratingComponent = this.item.rating;
    if (savedItemIndex && parseInt(savedItemIndex,10) === this.itemIndex && savedItem.document_id === this.item.document_id) {
      this.item = JSON.parse(localStorage.getItem('item'));
      this.ratingComponent = this.item.rating;
    }
  }

  onItemClick() {
    this.selectedItem.emit(this.item);
    console.log("Item clicked: ", this.item);
  }



}
