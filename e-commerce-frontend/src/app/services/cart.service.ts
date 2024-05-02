import {ProductModel} from "../shared/product.model";
import {ShoppingCartModel} from "../shared/shopping-cart.model";
import {Injectable} from "@angular/core";
import {Subject} from "rxjs";

@Injectable()
export class CartService {


  shoppingCart: ShoppingCartModel[] = [];

  shoppingCarListSubject = new Subject<ShoppingCartModel[]>();

  constructor() {
    const savedList = this.getShoppingListFromLocalStorage();
    if (savedList) {
      this.shoppingCart = savedList;
    }


  }


  addItemToShoppingCart(item: ProductModel) {
    let savedCartList = this.getShoppingListFromLocalStorage();
    let productId = item.document_id;
    let quantity = 1;
    let cartItem;
    for (let i of savedCartList) {
      if (productId === i.product.document_id) {
        quantity = i.quantity + 1;
        savedCartList.splice(savedCartList.indexOf(i), 1);
      }
    }

    cartItem = {product: item, quantity: quantity};
    savedCartList.push(cartItem);
    this.saveShoppingListInLocalStorage(savedCartList);
    return quantity;
  }

  resetShoppingCart() {
    this.shoppingCart = [];
    localStorage.removeItem('shoppingCartList');
  }

  removeItemFromCart(productId: string) {
    let quantity: number;
    let savedCartList = this.getShoppingListFromLocalStorage();
    let updatedCartList: ShoppingCartModel[] = [];


    for (let i of savedCartList) {

      if (i.product.document_id === productId) {
        quantity = Math.max(0, i.quantity - 1); // Ensure quantity doesn't go negative

        if (quantity > 0) {
          updatedCartList.push({product: i.product, quantity: quantity})
        }
      } else {
        updatedCartList.push(i);
      }

    }

    this.saveShoppingListInLocalStorage(updatedCartList);


    return quantity;

  }

  getQuantityForItem(itemData: ProductModel) {
    const savedCartList = this.getShoppingListFromLocalStorage();
    for (let i of savedCartList) {
      if (i.product.document_id === itemData.document_id) {
        return i.quantity;
      }
    }
    return 0;
  }

  saveShoppingListInLocalStorage(shoppingList: ShoppingCartModel[]) {
    localStorage.setItem('shoppingCartList', JSON.stringify(shoppingList));

    this.shoppingCarListSubject.next(shoppingList);

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

  clearCartList() {
    localStorage.removeItem('shoppingCartList');
    this.shoppingCarListSubject.next([]);


  }
}
