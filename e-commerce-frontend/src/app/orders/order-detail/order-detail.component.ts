import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {OrderPaymentsModel} from "../../shared/order-payments.model";

@Component({
  selector: 'app-order-detail',
  templateUrl: './order-detail.component.html',
  styleUrl: './order-detail.component.css'
})
export class OrderDetailComponent implements OnInit {

  orderItem!: OrderPaymentsModel;

  constructor(private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    const navigationState = window.history.state;
    this.orderItem = navigationState.item;

  }



}
