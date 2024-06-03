import {ComponentFixture, TestBed} from '@angular/core/testing';

import {ShoppingCartListComponent} from './shopping-cart-list.component';
import { Router } from '@angular/router';
import { CartService } from '../../services/cart.service';
import { ShoppingCartModel } from '../../shared/shopping-cart.model';
import { ProductModel } from '../../shared/product.model';

describe('ShoppingCartListComponent', () => {
  let component: ShoppingCartListComponent;
  let fixture: ComponentFixture<ShoppingCartListComponent>;
  let cartService: CartService;
  let router: Router;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ShoppingCartListComponent],
      providers: [
        { provide: CartService, useValue: new CartService() }
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShoppingCartListComponent);
    component = fixture.componentInstance;
    cartService = TestBed.inject(CartService);
    router = TestBed.inject(Router);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call clearCartList on cartService when onClearCart is called', () => {
    spyOn(cartService, 'clearCartList');
    component.onClearCart();
    expect(cartService.clearCartList).toHaveBeenCalled();
  });

  it('should navigate to /payment when onBuy is called', () => {
    component.onBuy();
    expect(router.navigate).toHaveBeenCalledWith(['/payment']);
  });

  it('should get shopping list from cartService when ngOnInit is called', () => {
    const product: ProductModel = {
      document_id: '1',
      name: 'test',
      price: 10,
      img: 'test.jpg',
      brand: 'test brand',
      category: 'test category',
      rating: 4,
      details: [{ keyText: 'test detail', imgPath: 'test value' }]
    };
    spyOn(cartService, 'getShoppingListFromLocalStorage').and.returnValue([
      { product: product, quantity: 2 }
    ]);
    component.ngOnInit();
    expect(component.cartList).toEqual([
      { product: product, quantity: 2 }
    ]);
  });

  it('should update cartList when shoppingCarListSubject emits a new value', () => {
    spyOn(cartService.shoppingCarListSubject, 'subscribe');
    component.ngOnInit();
    expect(cartService.shoppingCarListSubject.subscribe).toHaveBeenCalled();
    const product2: ProductModel = {
      document_id: '2',
      name: 'test2',
      price: 15,
      img: 'test2.jpg',
      brand: 'test2 brand',
      category: 'test2 category',
      rating: 3,
      details: [{ keyText: 'test2 detail', imgPath: 'test2 value' }]
    };
    const newCartList: ShoppingCartModel[] = [
      { product: product2, quantity: 3 }
    ];
    (cartService.shoppingCarListSubject as any).next(newCartList);
    expect(component.cartList).toEqual(newCartList);
  });
});
