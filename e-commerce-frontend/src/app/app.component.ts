import {Component, HostListener, OnInit} from '@angular/core';
import {AuthService} from "./services/auth.service";
import { map, Observable } from 'rxjs';
import { AppState } from './app.module';
import { select, Store } from '@ngrx/store';
import { appStateSelector, AuthState } from './store/state.selector';
import { UserModel } from './shared/user.model';
import { userDataSelector } from './store/auth/auth.selector';
import { loadCartItems } from './store/cart/cart.action';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'e-commerce-frontend';
  storedState$: Observable<AppState>;
  user$: Observable<UserModel>;

 
  constructor(private authService: AuthService,
    private store: Store<{appState: AppState}>,private storeAuth: Store<{authReducer: AuthState}>,
  ) {
  }


  ngOnInit(): void {
    this.authService.autoLogin();
    const cartData = localStorage.getItem('shoppingCartList');
    if (cartData) {
      const cartItems = JSON.parse(cartData);
      this.store.dispatch(loadCartItems({ cartItems }));
    }
    
  }


}
