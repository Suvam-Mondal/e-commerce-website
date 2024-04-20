import {Component, Input} from '@angular/core';
import {OrderPaymentsModel} from "../../../shared/order-payments.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-order-list-item',
  templateUrl: './order-list-item.component.html',
  styleUrl: './order-list-item.component.css'
})
export class OrderListItemComponent {
  @Input() item: OrderPaymentsModel;

  constructor(private router: Router) {
  }
  onViewDetail() {
      this.router.navigate(["/orders",this.item.orderId], {state: {item: this.item}});
  }
}
