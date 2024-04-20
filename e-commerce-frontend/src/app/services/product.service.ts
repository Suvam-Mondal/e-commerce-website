import {Injectable, OnInit} from "@angular/core";
import {ProductModel} from "../shared/product.model";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "./auth.service";

@Injectable()
export class ProductService implements OnInit {

  productForCategory: ProductModel[] = [];

  constructor(private http: HttpClient,
              private authService: AuthService) {
  }

  ngOnInit(): void {
  }

  getProductListForCategory(category: string) {

    let authToken = this.authService.getUserData();

    this.productForCategory = [];

    this.http.get<ProductModel[]>(`http://localhost:8081/products/${category}?authToken=${authToken.token}`)
      .subscribe(response => {
        for (let i of response) {
          let id = i.document_id;
          let name = i.name;
          let price = i.price;
          let img = i.img;
          let brand = i.brand;
          let category = i.category;

          let product: ProductModel = {
            document_id: id,
            name: name,
            price: price,
            brand: brand,
            category: category,
            img: img
          };
          this.productForCategory.push(product);

        }
      }, error => {
        console.log("Error while fetching products ", error.messageerror);
      })
    localStorage.setItem('productListForCategory', JSON.stringify(this.productForCategory));
    return this.productForCategory;
  }


}
