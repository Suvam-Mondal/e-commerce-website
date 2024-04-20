import {ShoppingCartModel} from "./shopping-cart.model";
import {PaymentInfoModel} from "./paymentInfo.model";

export interface OrderPaymentsModel {
  orderId: string;
  orderList: ShoppingCartModel[];
  paymentInfo: PaymentInfoModel;
}
