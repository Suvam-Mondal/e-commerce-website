import {Component, OnInit} from '@angular/core';
import {CartService} from "../../services/cart.service";
import {ShoppingCartModel} from "../../shared/shopping-cart.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-shopping-cart-list',
  templateUrl: './shopping-cart-list.component.html',
  styleUrl: './shopping-cart-list.component.css'
})
export class ShoppingCartListComponent implements OnInit{

  cartList: ShoppingCartModel[];

  constructor(private cartService: CartService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.cartList = this.cartService.getShoppingListFromLocalStorage();
    this.cartService.shoppingCarListSubject.subscribe(value => {
      this.cartList = value;
    })

  }


  onBuy() {
    this.router.navigate(["/payment"]);

  }

  onClearCart() {
    this.cartService.clearCartList();
  }
}
