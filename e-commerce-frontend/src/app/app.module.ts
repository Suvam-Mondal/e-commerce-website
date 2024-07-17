import {APP_INITIALIZER, NgModule} from '@angular/core';
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
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { GridComponent } from './products/products-list/product-grid-item/grid.component';
import { SortProductsPipe } from './utils/sort-products.pipe';
import { StarRatingComponent } from './star-rating/star-rating.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {MatIcon} from "@angular/material/icon";
import {MatCardModule} from "@angular/material/card";
import {MatListModule} from "@angular/material/list";
import { HeroContainerComponent } from './hero-container/hero-container.component';
import { ActionReducerMap, META_REDUCERS, MetaReducer, Store, StoreModule } from '@ngrx/store';
import { authReducer } from './store/auth/auth.reducer';
import { EffectsModule } from '@ngrx/effects';
import { AuthEffect } from './store/auth/auth.effect';
import { productReducer } from './store/product/product.reducer';
import { AuthState, CartState, ProductState } from './store/state.selector';
import { ProductEffect } from './store/product/product.effect';
import { cartReducer } from './store/cart/cart.reducer';
import { CartEffects } from './store/cart/cart.effects';




export interface AppState {
  auth: AuthState;
  product: ProductState;
  cart: CartState;
}

const reducers: ActionReducerMap<AppState> = {
  auth: authReducer,
  product: productReducer,
  cart: cartReducer
};



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
    OrderDetailComponent,
    GridComponent,
    SortProductsPipe,
    StarRatingComponent,
    HeroContainerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    FontAwesomeModule,
    MatIcon,
    MatCardModule,
    MatListModule,
    StoreModule.forRoot(reducers),
    EffectsModule.forRoot([AuthEffect, ProductEffect, CartEffects])
  ],
  providers: [ProductService, CartService, SearchService, OrderPaymentsService, AuthService, provideAnimationsAsync()],
  bootstrap: [AppComponent]
})
export class AppModule {
}
