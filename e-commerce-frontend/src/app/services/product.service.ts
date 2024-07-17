import {Injectable, OnInit} from "@angular/core";
import {ProductModel} from "../shared/product.model";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AuthService} from "./auth.service";
import {first, Observable, Subject, tap} from "rxjs";
import {Details} from "../shared/product-details.model";
import { Store } from "@ngrx/store";
import { ProductState } from "../store/state.selector";
import { fetchProducts } from "../store/product/product.action";
import { selectProductList } from "../store/product/product.selector";

@Injectable()
export class ProductService implements OnInit {

  productForCategory: ProductModel[] = [];
  displayListToggle = new Subject<boolean>();
  sortBy = new Subject<string>();
  productList$: Observable<ProductModel[]>;

  constructor(private http: HttpClient,
              private authService: AuthService,
              private store: Store<{product: ProductState}>) {
  }

  ngOnInit(): void {
  }

  getProductListForCategory(category: string): Observable<any> {
    this.store.dispatch(fetchProducts({ category }));
  
    return this.store.select(selectProductList).pipe(
      tap(productList => {
        this.productForCategory = productList;
      })
    );
  }


  updateDisplayListToggle(isDisplayAsList: boolean) {
    localStorage.setItem('displayToggleValue', JSON.stringify(isDisplayAsList));
    this.displayListToggle.next(isDisplayAsList);
  }

  sortList(value: string) {
    localStorage.setItem('sortByKey', value);
    this.sortBy.next(value);
  }

  getStoredSortByValue() {
    return localStorage.getItem('sortByKey');
  }

  getStoredDisplayToggleValue() {
    return JSON.parse(localStorage.getItem('displayToggleValue'));
  }

}
