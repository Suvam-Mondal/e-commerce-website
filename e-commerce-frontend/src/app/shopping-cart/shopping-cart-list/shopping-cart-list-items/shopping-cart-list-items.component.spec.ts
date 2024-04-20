import {ComponentFixture, TestBed} from '@angular/core/testing';

import {ShoppingCartListItemsComponent} from './shopping-cart-list-items.component';

describe('ShoppingCartListItemsComponent', () => {
  let component: ShoppingCartListItemsComponent;
  let fixture: ComponentFixture<ShoppingCartListItemsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ShoppingCartListItemsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShoppingCartListItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
