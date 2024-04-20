import {Component, OnInit} from '@angular/core';
import {OrderPaymentsService} from "../../services/order-payments.service";
import {OrderPaymentsModel} from "../../shared/order-payments.model";

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrl: './order-list.component.css'
})
export class OrderListComponent implements OnInit{

  orderList: OrderPaymentsModel[] = [];


  constructor(private orderPaymentService: OrderPaymentsService) {
  }

  ngOnInit(): void {
    let orderForUser = this.orderPaymentService.getOrderForUser();
    orderForUser.subscribe(response => {
      for (let i of response) {

        //this.orderList = [...this.orderList, ...i];
        this.orderList.push(i);
      }
    }, error => {
      console.log("Error while fetching order list for user...", error)
    })
  }
}
