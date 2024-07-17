import { Component, ElementRef, EventEmitter, Input, OnDestroy, OnInit, Output, ViewChild } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from "@angular/router";
import { ProductModel } from "../../shared/product.model";
import { Details } from "../../shared/product-details.model";
import { combineLatest, filter, map, Subscription } from "rxjs";
import { select, Store } from '@ngrx/store';
import { addToCartAction, removeFromCartAction } from '../../store/cart/cart.action';
import { CartState } from '../../store/state.selector';
import { selectCartItems } from '../../store/cart/cart.selector';


@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrl: './product-detail.component.css'
})
export class ProductDetailComponent implements OnInit, OnDestroy {

  //@Input("selectedItem") itemData!: ProductModel;
  @Output() selectedItemReceived = new EventEmitter<ProductModel>();

  shouldDisplayItemControls: boolean;
  quantity: number;
  @ViewChild('listContainer') listContainer!: ElementRef; //check and remove
  itemDetails: Details[] = [];
  private subscriptions = new Subscription();



  constructor(private activatedRoute: ActivatedRoute,
    private router: Router,
    private store: Store<{ cart: CartState }>) { }


    ngOnInit(): void {

      this.router.events
      .pipe(filter(event => event instanceof NavigationEnd))
      .subscribe((event: NavigationEnd) => {
        window.scrollTo(0, 0); // Scrolls to the top of the page
      });
      
      // Get item data from route params and localStorage (if needed)
      combineLatest([
        this.activatedRoute.params,
        this.store.pipe(select(selectCartItems)) // Get cart items from NgRx store
      ]).pipe(
        map(([params, cartItems]) => {
          //this.itemData = JSON.parse(localStorage.getItem('item')); // Get data from localStorage (if applicable)
          
          //const matchingItem = cartItems.find(item => item.product.document_id === this.itemData.document_id); // Calculate initial quantity from cart items
         // this.quantity = matchingItem ? matchingItem.quantity : 0;

          this.shouldDisplayItemControls = this.quantity >= 1; // Update shouldDisplayItemControls based on quantity
                   
          console.log("itemData = ",this.selectedItemReceived);

          //this.itemDetails = this.itemData.details;
        }),
      ).subscribe();
    }

    ngOnDestroy(): void {
      this.subscriptions.unsubscribe();
    }
    

  onAddToCart() {
   // this.store.dispatch(addToCartAction({ product: this.itemData }));
    this.shouldDisplayItemControls = true;
  }

  removeItem() {
   // this.store.dispatch(removeFromCartAction({ itemId: this.itemData.document_id }));
  }

  addItem() {
   // this.store.dispatch(addToCartAction({ product: this.itemData }));
  }
}
