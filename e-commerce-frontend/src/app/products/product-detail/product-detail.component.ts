import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {ProductService} from "../../services/product.service";
import {ProductModel} from "../../shared/product.model";
import {CartService} from "../../services/cart.service";

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrl: './product-detail.component.css'
})
export class ProductDetailComponent implements  OnInit{

  itemData: ProductModel;
  shouldDisplayItemControls: boolean;
  quantity: number;


  constructor(private activatedRoute: ActivatedRoute,
              private productService: ProductService,
              private cartService: CartService) {}


  ngOnInit(): void {
    this.activatedRoute
      .params
      .subscribe(
        (p: Params) =>{

         // let id = p['id'];

          const storedItem = localStorage.getItem('item');
          if (storedItem) {
            this.itemData = JSON.parse(storedItem);
            this.quantity = this.cartService.getQuantityForItem(this.itemData);
            if (this.quantity > 0) {
              this.shouldDisplayItemControls = true;
            }
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
