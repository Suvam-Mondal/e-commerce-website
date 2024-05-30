import {HttpClient, HttpHeaders} from "@angular/common/http";
import {OrderPaymentsModel} from "../shared/order-payments.model";
import {Router} from "@angular/router";
import {CartService} from "./cart.service";
import {Injectable} from "@angular/core";
import {AuthService} from "./auth.service";

@Injectable()
export class OrderPaymentsService {


  constructor(private router: Router,
              private http: HttpClient,
              private cartService: CartService,
              private authService: AuthService) {
  }

  saveOrder(orderPaymentInfo: OrderPaymentsModel) {
    let userData = this.authService.getUserData();

      const headers = new HttpHeaders({
              'Content-Type': 'application/json',
              'Authorization': 'Bearer '+userData.authToken
              });


    this.http.post(`http://localhost:8081/orders`,orderPaymentInfo, {headers})
      .subscribe(response => {
        this.cartService.resetShoppingCart();
        this.router.navigate(["/orders"]);

      }, error => {
        console.log("Error while saving order info");
      });


  }

  getOrderForUser() {
    let userData = this.authService.getUserData();
      const headers = new HttpHeaders({
                  'Content-Type': 'application/json',
                  'Authorization': 'Bearer '+userData.authToken
                  });

    return this.http.get<OrderPaymentsModel[]>(`http://localhost:8081/orders?userEmail=${userData.email}`,{headers});
  }
}
