import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {OrderPaymentsService} from "../../services/order-payments.service";
import {OrderPaymentsModel} from "../../shared/order-payments.model";
import {v4 as uuidv4} from 'uuid';
import {CartService} from "../../services/cart.service";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrl: './payment.component.css'
})
export class PaymentComponent implements OnInit{

  paymentForm: FormGroup;

  constructor(private orderPaymentService: OrderPaymentsService,
              private cartService: CartService,
              private authService: AuthService) {
  }

  ngOnInit(): void {
    this.paymentForm = new FormGroup(
      {
        'ccNo': new FormControl(null),
        'ccExpDate': new FormControl(null),
        'ccCvv': new FormControl(null),
      }
    );
  }

  onConfirmPay() {

    let ccNo: string = this.paymentForm.get('ccNo').value;

    let uuid = uuidv4();
    let orderList= this.cartService.getShoppingListFromLocalStorage();
    let paymentInfo = {
      paymentType: 'card',
      paymentStatus: 'paid',
      paymentCardNumber: ccNo,
      registeredEmail: this.authService.getUserData().email
    }
    let orderPaymentInfo: OrderPaymentsModel = {
      orderId: uuid,
      orderList: orderList,
      paymentInfo: paymentInfo
    };

    this.orderPaymentService.saveOrder(orderPaymentInfo);

  }


}
