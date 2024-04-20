import {Component, Input, OnInit} from '@angular/core';
import {ShoppingCartModel} from "../../../shared/shopping-cart.model";
import {CartService} from "../../../services/cart.service";

@Component({
  selector: 'app-shopping-cart-list-items',
  templateUrl: './shopping-cart-list-items.component.html',
  styleUrl: './shopping-cart-list-items.component.css'
})
export class ShoppingCartListItemsComponent implements OnInit{
  @Input() item!: ShoppingCartModel;
  totalPrice: number;



  constructor(private cartService:CartService) {
  }

  ngOnInit(): void {
    this.totalPrice = this.item.quantity * this.item.product.price;

  }

  onReduceItemQuantity() {
    this.cartService.removeItemFromCart(this.item.product.document_id);

  }

  onIncreaseItemQuantity() {
    this.cartService.addItemToShoppingCart(this.item.product);

  }


}
