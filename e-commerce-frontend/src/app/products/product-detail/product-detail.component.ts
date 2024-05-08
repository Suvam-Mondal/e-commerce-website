import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, NavigationEnd, Params, Router} from "@angular/router";
import {ProductService} from "../../services/product.service";
import {ProductModel} from "../../shared/product.model";
import {CartService} from "../../services/cart.service";
import {HeroContainerComponent} from "../../hero-container/hero-container.component";
import {Details} from "../../shared/product-details.model";
import {filter} from "rxjs";

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrl: './product-detail.component.css'
})
export class ProductDetailComponent implements  OnInit{

  itemData: ProductModel;
  shouldDisplayItemControls: boolean;
  quantity: number;
  @ViewChild('listContainer') listContainer!: ElementRef;
  i: Details[] = [];


  constructor(private activatedRoute: ActivatedRoute,
              private productService: ProductService,
              private cartService: CartService,
              private router: Router) {}


  ngOnInit(): void {
    this.router.events
      .pipe(filter(event => event instanceof NavigationEnd))
      .subscribe((event: NavigationEnd) => {
        console.log("scrolling up");
        window.scrollTo(0, 0); // Scrolls to the top of the page
      });
    this.activatedRoute
      .params
      .subscribe(
        (p: Params) =>{

          const storedItem = localStorage.getItem('item');
          if (storedItem) {
            this.itemData = JSON.parse(storedItem);
            this.quantity = this.cartService.getQuantityForItem(this.itemData);
            if (this.quantity > 0) {
              this.shouldDisplayItemControls = true;
            }
            this.i =this.itemData.details;
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
