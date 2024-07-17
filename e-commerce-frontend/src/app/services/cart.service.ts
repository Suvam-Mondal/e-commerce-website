import { Store } from "@ngrx/store";
import {ProductModel} from "../shared/product.model";
import {ShoppingCartModel} from "../shared/shopping-cart.model";
import {Injectable} from "@angular/core";
import {Observable, Subject, tap} from "rxjs";
import { CartState } from "../store/state.selector";
import { getCartItemsFromLocalStorage } from "../store/cart/cart.selector";

@Injectable()
export class CartService {


  shoppingCart: ShoppingCartModel[] = [];
  cartList$: Observable<ShoppingCartModel[]>;

  shoppingCarListSubject = new Subject<ShoppingCartModel[]>();

  constructor(private store:Store<{cart: CartState}>) {}

 
  resetShoppingCart() {
    this.shoppingCart = [];
    localStorage.removeItem('shoppingCartList');
  }

 

  getShoppingListFromLocalStorage() {
    let savedCartList = localStorage.getItem('shoppingCartList');

    if (savedCartList) {
      let savedList = JSON.parse(savedCartList);

      return savedList;
    } else {
      let blankCart: ShoppingCartModel[] = [];
      return blankCart;
    }
  }
}
