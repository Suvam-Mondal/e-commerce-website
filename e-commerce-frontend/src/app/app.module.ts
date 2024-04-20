import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {ProductsComponent} from './products/products.component';
import {ProductsListComponent} from './products/products-list/products-list.component';
import {ProductListItemComponent} from './products/products-list/product-list-item/product-list-item.component';
import {ProductCategoriesComponent} from './product-categories/product-categories.component';
import {ProductListFilterComponent} from './product-list-filter/product-list-filter.component';
import {ProductDetailComponent} from './products/product-detail/product-detail.component';
import {ProductService} from "./services/product.service";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CategoryFilterPipe} from './utils/category-filter.pipe';
import {CartService} from "./services/cart.service";
import {ShoppingCartComponent} from './shopping-cart/shopping-cart.component';
import {ShoppingCartListComponent} from './shopping-cart/shopping-cart-list/shopping-cart-list.component';
import {
  ShoppingCartListItemsComponent
} from './shopping-cart/shopping-cart-list/shopping-cart-list-items/shopping-cart-list-items.component';
import {SearchService} from "./services/search.service";
import {SearchListComponent} from './search-list/search-list.component';
import {SearchListItemComponent} from './search-list/search-list-item/search-list-item.component';
import {SearchItemDetailComponent} from './search-list/search-item-detail/search-item-detail.component';
import {PaymentComponent} from './shopping-cart/payment/payment.component';
import {OrdersComponent} from './orders/orders.component';
import {HttpClientModule} from "@angular/common/http";
import {OrderPaymentsService} from "./services/order-payments.service";
import {OrderListComponent} from './orders/order-list/order-list.component';
import {OrderListItemComponent} from './orders/order-list/order-list-item/order-list-item.component';
import {AuthComponent} from './auth/auth.component';
import {LoadingSpinnerComponent} from "./shared/loading-spinner/loading-spinner.component";
import {AuthService} from "./services/auth.service";
import {OrderDetailComponent} from './orders/order-detail/order-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ProductsComponent,
    ProductsListComponent,
    ProductListItemComponent,
    ProductCategoriesComponent,
    ProductListFilterComponent,
    ProductDetailComponent,
    CategoryFilterPipe,
    ShoppingCartComponent,
    ShoppingCartListComponent,
    ShoppingCartListItemsComponent,
    SearchListComponent,
    SearchListItemComponent,
    SearchItemDetailComponent,
    PaymentComponent,
    OrdersComponent,
    OrderListComponent,
    OrderListItemComponent,
    AuthComponent,
    LoadingSpinnerComponent,
    OrderDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [ProductService, CartService, SearchService, OrderPaymentsService, AuthService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
