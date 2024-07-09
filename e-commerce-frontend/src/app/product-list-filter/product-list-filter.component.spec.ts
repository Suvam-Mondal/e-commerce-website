import {ComponentFixture, TestBed} from '@angular/core/testing';

import {ProductListFilterComponent} from './product-list-filter.component';
import { ProductService } from '../services/product.service';
import { ElementRef } from '@angular/core';

describe('ProductListFilterComponent', () => {
  let component: ProductListFilterComponent;
  let fixture: ComponentFixture<ProductListFilterComponent>;
  let productService: jasmine.SpyObj<ProductService>;

  beforeEach(async () => {
    const spy = jasmine.createSpyObj('ProductService', ['getStoredDisplayToggleValue', 'getStoredSortByValue', 'updateDisplayListToggle', 'sortList']);

    await TestBed.configureTestingModule({
      declarations: [ProductListFilterComponent],
      providers: [
        { provide: ProductService, useValue: spy }
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductListFilterComponent);
    component = fixture.componentInstance;
    productService = TestBed.inject(ProductService) as jasmine.SpyObj<ProductService>;

    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should initialize isDisplayAsList from ProductService on ngOnInit', () => {
    productService.getStoredDisplayToggleValue.and.returnValue(true);
    component.ngOnInit();
    expect(component.isDisplayAsList).toBeTrue();
    expect(productService.getStoredDisplayToggleValue).toHaveBeenCalled();
  });

  it('should set sortSelect value from ProductService on ngAfterViewInit', () => {
    const nativeElement = document.createElement('select');
    component.sortSelect = { nativeElement } as ElementRef<HTMLSelectElement>;
    productService.getStoredSortByValue.and.returnValue('price');
    component.ngAfterViewInit();
    expect(component.sortSelect.nativeElement.value).toBe('price');
    expect(productService.getStoredSortByValue).toHaveBeenCalled();
  });

  it('should toggle isDisplayAsList and update ProductService on onChangeListView', () => {
    productService.updateDisplayListToggle.and.stub();
    component.isDisplayAsList = false;
    component.onChangeListView();
    expect(component.isDisplayAsList).toBeTrue();
    expect(productService.updateDisplayListToggle).toHaveBeenCalledWith(true);
  });

  it('should call sortList on ProductService on onSortOptionSelected', () => {
    productService.sortList.and.stub();
    const event = new Event('change', { bubbles: true, cancelable: true });
    Object.defineProperty(event, 'target', { value: { value: 'name' }, enumerable: true });

    component.onSortOptionSelected(event);
    expect(productService.sortList).toHaveBeenCalledWith('name');
  });
});
