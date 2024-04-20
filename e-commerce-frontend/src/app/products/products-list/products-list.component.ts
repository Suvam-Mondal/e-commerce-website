import {Component, OnDestroy, OnInit} from '@angular/core';
import {ProductModel} from "../../shared/product.model";
import {ProductService} from "../../services/product.service";
import {Subscription} from "rxjs";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrl: './products-list.component.css'
})
export class ProductsListComponent  implements OnInit, OnDestroy{
  productList: ProductModel[];

  currentCategorySubscriber = new Subscription();
  selectedCategory: string;


  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params =>  {
      this.selectedCategory = params.get('category');
      this.productList = this.productService.getProductListForCategory(this.selectedCategory);
    });

  }

  ngOnDestroy(): void {
    this.currentCategorySubscriber.unsubscribe();
  }
}
