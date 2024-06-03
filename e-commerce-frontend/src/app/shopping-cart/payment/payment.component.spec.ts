import {ComponentFixture, TestBed} from '@angular/core/testing';

import {PaymentComponent} from './payment.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { CartService } from '../../services/cart.service';
import { OrderPaymentsService } from '../../services/order-payments.service';
import { UserModel } from '../../shared/user.model';

describe('PaymentComponent', () => {
  let component: PaymentComponent;
  let fixture: ComponentFixture<PaymentComponent>;
  let cartService: CartService;
  let authService: AuthService;
  let orderPaymentService: OrderPaymentsService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PaymentComponent],
      imports: [ ReactiveFormsModule, HttpClientModule ],
      providers: [
        OrderPaymentsService,
        AuthService,
        CartService
      ]

    })
    .compileComponents();

    fixture = TestBed.createComponent(PaymentComponent);
    component = fixture.componentInstance;
    cartService = TestBed.inject(CartService);
    authService = TestBed.inject(AuthService);
    orderPaymentService = TestBed.inject(OrderPaymentsService);

    // Replace the original saveOrder method with a spy
    spyOn(orderPaymentService, 'saveOrder');

    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should save order', () => {
    const mockUser: UserModel = new UserModel('test@gmail.com', 'abcdToken', null);
    spyOn(cartService, 'getShoppingListFromLocalStorage').and.returnValue([]);
    spyOn(authService, 'getUserData').and.returnValue(mockUser);

    const ccNoValue = '111122223333';
    component.paymentForm.patchValue({ 'ccNo': ccNoValue });
    component.onConfirmPay();

    expect(orderPaymentService.saveOrder).toHaveBeenCalledTimes(1);

  });
});
