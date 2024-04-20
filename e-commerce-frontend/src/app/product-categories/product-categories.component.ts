import {Component} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-categories',
  templateUrl: './product-categories.component.html',
  styleUrl: './product-categories.component.css'
})
export class ProductCategoriesComponent{

  categories: string[] = ["mobile", "clothing","toy"];

  constructor(private router: Router) {
  }

}
