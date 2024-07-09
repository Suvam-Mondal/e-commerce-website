import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductListItemComponent } from './product-list-item.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { AuthService } from '../../../services/auth.service';
import { ProductService } from '../../../services/product.service';
import { StarRatingComponent } from '../../../star-rating/star-rating.component';
import { RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { MatIconModule } from '@angular/material/icon';

describe('ProductListItemComponent', () => {
  let component: ProductListItemComponent;
  let fixture: ComponentFixture<ProductListItemComponent>;
  let productService: ProductService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ProductListItemComponent, StarRatingComponent],
      imports: [ReactiveFormsModule, HttpClientModule, RouterModule, RouterTestingModule, MatIconModule],
      providers: [
        ProductService,
        AuthService
      ]
    })
      .compileComponents();

    fixture = TestBed.createComponent(ProductListItemComponent);
    component = fixture.componentInstance;
    productService = TestBed.inject(ProductService);

    // Set the value of this.item.rating
    component.item = {
      document_id: '1',
      name: 'test',
      price: 10,
      img: 'test.jpg',
      brand: 'test brand',
      category: 'test category',
      rating: 4, // Set the rating value here
      details: [{ keyText: 'test detail', imgPath: 'test value' }]
    };

    // Stub localStorage methods
    spyOn(localStorage, 'getItem').and.returnValue(JSON.stringify({
      document_id: '1',
      name: 'test',
      price: 10,
      img: 'test.jpg',
      brand: 'test brand',
      category: 'test category',
      rating: 4,
      details: [{ keyText: 'test detail', imgPath: 'test value' }]
    }));
    spyOn(localStorage, 'setItem');
    fixture.detectChanges();

  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should save selected list item to localStorage', () => {
    component.itemIndex = 1;
    component.item = {
      document_id: '1',
      name: 'test',
      price: 10,
      img: 'test.jpg',
      brand: 'test brand',
      category: 'test category',
      rating: 4,
      details: [{ keyText: 'test detail', imgPath: 'test value' }]
    }; // Provide necessary properties for ProductModel
    component.saveSelectedListItem();

    expect(localStorage.setItem).toHaveBeenCalledWith('itemIndex', JSON.stringify(1));
    expect(localStorage.setItem).toHaveBeenCalledWith('item', JSON.stringify(component.item));
  });


});
