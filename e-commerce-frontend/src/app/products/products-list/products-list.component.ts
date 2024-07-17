import {Component, EventEmitter, OnDestroy, OnInit, Output} from '@angular/core';
import {ProductModel} from "../../shared/product.model";
import {ProductService} from "../../services/product.service";
import {Subscription, switchMap} from "rxjs";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrl: './products-list.component.css'
})
export class ProductsListComponent  implements OnInit, OnDestroy{
  productList: ProductModel[];

  currentCategorySubscriber = new Subscription();
  displayListToggleSubscriber = new Subscription();
  sortBySubscriber = new Subscription();
  selectedCategory: string;
  shouldDisplayAsList: boolean;
  sortItemsBy: string;


  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {

    this.sortItemsBy = this.productService.getStoredSortByValue();
    this.shouldDisplayAsList = this.productService.getStoredDisplayToggleValue();

    this.activatedRoute.paramMap
    .pipe(
      switchMap(params => this.productService.getProductListForCategory(params.get('category')))
    )
    .subscribe(productList => {
      this.productList = productList;
    });

   this.displayListToggleSubscriber = this.productService.displayListToggle
     .subscribe(newVal => {
       this.shouldDisplayAsList = newVal;
   });

   this.sortBySubscriber = this.productService.sortBy
     .subscribe(newVal => {
       this.sortItemsBy = newVal;

   });


  }


  ngOnDestroy(): void {
    this.currentCategorySubscriber.unsubscribe();
    this.displayListToggleSubscriber.unsubscribe();
    this.sortBySubscriber.unsubscribe();
  }
}
