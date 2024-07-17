import {Component, Input, OnInit} from '@angular/core';
import {ShoppingCartModel} from "../../../shared/shopping-cart.model";
import {CartService} from "../../../services/cart.service";
import { CartState } from '../../../store/state.selector';
import { Store } from '@ngrx/store';
import { removeFromCartAction, addToCartAction } from '../../../store/cart/cart.action';

@Component({
  selector: 'app-shopping-cart-list-items',
  templateUrl: './shopping-cart-list-items.component.html',
  styleUrl: './shopping-cart-list-items.component.css'
})
export class ShoppingCartListItemsComponent implements OnInit{
  @Input() item!: ShoppingCartModel;
  totalPrice: number;



  constructor(private cartService:CartService,
    private store: Store<{cart: CartState}>) {}

  ngOnInit(): void {
  
    this.totalPrice = this.item.quantity * this.item.product.price;

  }

  onReduceItemQuantity() {
    this.store.dispatch(removeFromCartAction({ itemId: this.item.product.document_id }));

  }

  onIncreaseItemQuantity() {
    this.store.dispatch(addToCartAction({ product: this.item.product }));

  }


}
