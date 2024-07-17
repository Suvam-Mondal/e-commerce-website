import { Component, OnInit } from '@angular/core';
import { ShoppingCartModel } from "../../shared/shopping-cart.model";
import { Router } from "@angular/router";
import { Store } from '@ngrx/store';
import { CartState } from '../../store/state.selector';
import { resetCartList } from '../../store/cart/cart.action';
import { selectCartItems } from '../../store/cart/cart.selector';

@Component({
  selector: 'app-shopping-cart-list',
  templateUrl: './shopping-cart-list.component.html',
  styleUrl: './shopping-cart-list.component.css'
})
export class ShoppingCartListComponent implements OnInit {

  cartList: ShoppingCartModel[] = [];

  constructor(private router: Router,
    private store: Store<{ cart: CartState }>) {
  }

  ngOnInit(): void {
    this.store.select(selectCartItems).subscribe(items => {
      this.cartList = items;
    });
  }


  onBuy() {
    this.router.navigate(["/payment"]);

  }

  onClearCart() {
    this.store.dispatch(resetCartList());
  }
}
