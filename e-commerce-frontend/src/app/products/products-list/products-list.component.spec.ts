import {ComponentFixture, TestBed} from '@angular/core/testing';

import {ProductsListComponent} from './products-list.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, convertToParamMap } from '@angular/router';
import { ProductService } from '../../services/product.service';
import { of } from 'rxjs';
import { AuthService } from '../../services/auth.service';
import { SortProductsPipe } from '../../utils/sort-products.pipe';
import { RouterTestingModule } from '@angular/router/testing';

describe('ProductsListComponent', () => {
  let component: ProductsListComponent;
  let fixture: ComponentFixture<ProductsListComponent>;
  let productService: ProductService;
  let activatedRoute: ActivatedRoute;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ProductsListComponent, SortProductsPipe],
      imports: [ ReactiveFormsModule, HttpClientModule, RouterTestingModule  ],
      providers: [
        {
          provide: ActivatedRoute,
          useValue: {
            paramMap: of(convertToParamMap({ category: 'testCategory' }))
          }
        },
        ProductService,
        AuthService
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductsListComponent);
    component = fixture.componentInstance;
    productService = TestBed.inject(ProductService);
    activatedRoute = TestBed.inject(ActivatedRoute);

    spyOn(productService, 'getStoredSortByValue').and.returnValue('default');
    spyOn(productService, 'getStoredDisplayToggleValue').and.returnValue(false);
    spyOn(productService, 'getProductListForCategory').and.returnValue([]);
    spyOn(productService.displayListToggle, 'subscribe').and.callThrough();
    spyOn(productService.sortBy, 'subscribe').and.callThrough();
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should set initial values on ngOnInit', () => {
    expect(productService.getStoredSortByValue).toHaveBeenCalled();
    expect(productService.getStoredDisplayToggleValue).toHaveBeenCalled();
    expect(productService.getProductListForCategory).toHaveBeenCalledWith('testCategory');
    expect(component.sortItemsBy).toEqual('default');
    expect(component.shouldDisplayAsList).toBeFalse();
    expect(productService.displayListToggle.subscribe).toHaveBeenCalled();
    expect(productService.sortBy.subscribe).toHaveBeenCalled();
  });

  it('should unsubscribe on ngOnDestroy', () => {
    spyOn(component.currentCategorySubscriber, 'unsubscribe');
    spyOn(component.displayListToggleSubscriber, 'unsubscribe');
    spyOn(component.sortBySubscriber, 'unsubscribe');

    component.ngOnDestroy();

    expect(component.currentCategorySubscriber.unsubscribe).toHaveBeenCalled();
    expect(component.displayListToggleSubscriber.unsubscribe).toHaveBeenCalled();
    expect(component.sortBySubscriber.unsubscribe).toHaveBeenCalled();
  });
});
