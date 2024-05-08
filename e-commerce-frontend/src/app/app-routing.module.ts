import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProductDetailComponent} from "./products/product-detail/product-detail.component";
import {ProductsComponent} from "./products/products.component";
import {ShoppingCartComponent} from "./shopping-cart/shopping-cart.component";
import {SearchListComponent} from "./search-list/search-list.component";
import {SearchItemDetailComponent} from "./search-list/search-item-detail/search-item-detail.component";
import {PaymentComponent} from "./shopping-cart/payment/payment.component";
import {OrdersComponent} from "./orders/orders.component";
import {AuthComponent} from "./auth/auth.component";
import {OrderDetailComponent} from "./orders/order-detail/order-detail.component";

const routes: Routes = [
  {path:'', redirectTo:"/login", pathMatch:"full"},
   {path:'login', component: AuthComponent},
  {path:'products', redirectTo:"/products/mobile", pathMatch:"full"},
  {path:'products/:category', component:ProductsComponent},
  {path:'products/:category/:id', component:ProductDetailComponent},
  {path:'cart', component:ShoppingCartComponent},
  {path:'search', component:SearchListComponent},
  {path:'search/:id', component:SearchItemDetailComponent},
  {path:'payment', component: PaymentComponent},
  {path:'orders', component: OrdersComponent},
  {path:'orders/:orderId', component: OrderDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
