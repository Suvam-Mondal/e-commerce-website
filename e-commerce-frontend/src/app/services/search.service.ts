import {Injectable} from "@angular/core";
import {Router} from "@angular/router";
import {ProductModel} from "../shared/product.model";
import {HttpClient} from "@angular/common/http";
import {AuthService} from "./auth.service";

@Injectable()
export class SearchService {

  searchList: ProductModel[] = [];

  constructor(private router: Router,
              private authService: AuthService,
              private http: HttpClient) {
  }

  displayMatchingList(value: string) {
    this.router.navigate(["/search"], {queryParams: {searchKey: value}});
  }

  getProductDetail(id: any) {
    return this.searchList[id];
  }

  getProductListMatchingSearchParam(searchKey: string, searchCategory: string) {
    let authToken = this.authService.getUserData();

    this.searchList = [];
    this.http.get<ProductModel[]>(`http://localhost:8081/products/mongo/search/${searchKey}?authToken=${authToken.token}`)
      .subscribe(response =>{
        for (let i of response) {
          let id = i.document_id;
          let name = i.name;
          let price = i.price;
          let img = i.img;
          let brand = i.brand;
          let category = i.category;
          let rating = i.rating;
          let detail = i.details;

          let product: ProductModel = {document_id: id, name: name, price: price, brand: brand, category: category, img: img, rating:rating,
            details: detail};
          this.searchList.push(product);

        }
      }, error => {
        console.log("Error while fetching products ", error.messageerror);
      })
    return this.searchList;
  }

}
