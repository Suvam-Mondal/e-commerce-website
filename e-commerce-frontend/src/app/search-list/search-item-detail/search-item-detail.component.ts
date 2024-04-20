import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {CartService} from "../../services/cart.service";
import {ProductModel} from "../../shared/product.model";
import {SearchService} from "../../services/search.service";

@Component({
  selector: 'app-search-item-detail',
  templateUrl: '../../products/product-detail/product-detail.component.html',
  styleUrl: '../../products/product-detail/product-detail.component.css'
})
export class SearchItemDetailComponent implements OnInit {

  itemData: ProductModel;
  shouldDisplayItemControls: boolean;
  quantity: number;

  constructor(private activatedRoute: ActivatedRoute,
              private searchService: SearchService,
              private cartService: CartService) {
  }

  ngOnInit(): void {
    let id: number;

    this.activatedRoute.params.subscribe((p: Params) => {
        id = p['id'];
        let searchItemIndex: number = JSON.parse(localStorage.getItem('searchItemIndex'));
        if (searchItemIndex && searchItemIndex === id) {
          this.itemData = JSON.parse(localStorage.getItem('searchItemData'));
        } else {
          localStorage.setItem('searchItemIndex', JSON.stringify(id));
          this.itemData = this.searchService.getProductDetail(id);
          localStorage.setItem('searchItemData', JSON.stringify(this.itemData));
        }
        this.quantity = this.cartService.getQuantityForItem(this.itemData);
        if (this.quantity > 0) {
          this.shouldDisplayItemControls = true;
        }
      }
    );
  }


  onAddToCart() {
    this.quantity = this.cartService.addItemToShoppingCart(this.itemData);
    this.shouldDisplayItemControls = true;

  }

  removeItem() {
    this.quantity = this.cartService.removeItemFromCart(this.itemData.document_id);
    if (this.quantity <= 0) {
      this.shouldDisplayItemControls = false;
    }

  }

  addItem() {
    this.quantity = this.cartService.addItemToShoppingCart(this.itemData);
  }

}
