import {Injectable, OnInit} from "@angular/core";
import {ProductModel} from "../shared/product.model";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "./auth.service";
import {Subject} from "rxjs";
import {Details} from "../shared/product-details.model";

@Injectable()
export class ProductService implements OnInit {

  productForCategory: ProductModel[] = [];
  displayListToggle = new Subject<boolean>();
  sortBy = new Subject<string>();

  constructor(private http: HttpClient,
              private authService: AuthService) {
  }

  ngOnInit(): void {
  }

  getProductListForCategory(category: string) {

    let authToken = this.authService.getUserData();

    this.productForCategory = [];

    this.http.get<ProductModel[]>(`http://localhost:8081/products/mongo/${category}?authToken=${authToken.token}`)
      .subscribe(response => {
        for (let i of response) {
          let id = i.document_id;
          let name = i.name;
          let price = i.price;
          let img = i.img;
          let brand = i.brand;
          let category = i.category;
          let rating = i.rating;
          let detail = i.details;

          let product: ProductModel = {
            document_id: id,
            name: name,
            price: price,
            brand: brand,
            category: category,
            img: img,
            rating: rating,
            details: detail
          };
          this.productForCategory.push(product);

        }
        //localStorage.setItem('productListForCategory', JSON.stringify(this.productForCategory));

      }, error => {
        console.log("Error while fetching products ", error.messageerror);
      })

    return this.productForCategory;
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
