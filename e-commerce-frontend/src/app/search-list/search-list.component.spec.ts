import {ComponentFixture, TestBed} from '@angular/core/testing';

import {SearchListComponent} from './search-list.component';
import { ActivatedRoute, convertToParamMap } from '@angular/router';
import { of } from 'rxjs';
import { SearchService } from '../services/search.service';
import { ProductModel } from '../shared/product.model';
import { AuthService } from '../services/auth.service';
import { HttpClient, HttpClientModule, HttpHandler } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { ProductService } from '../services/product.service';

describe('SearchListComponent', () => {
  let component: SearchListComponent;
  let fixture: ComponentFixture<SearchListComponent>;
  let activatedRoute: ActivatedRoute;
  let searchService: SearchService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SearchListComponent],
      imports: [ ReactiveFormsModule, HttpClientModule ],
      providers: [
        {
          provide: ActivatedRoute,
          useValue: {
            queryParamMap: of(convertToParamMap({ searchKey: 'test', searchCategory: 'all' }))
          }
        },
        SearchService,
        AuthService
      ]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchListComponent);
    component = fixture.componentInstance;
    activatedRoute = TestBed.inject(ActivatedRoute);
    searchService = TestBed.inject(SearchService);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should fetch product list matching search param on init', () => {
    const productList: ProductModel[] = [
      {
        document_id: '1',
        name: 'test',
        price: 10,
        img: 'test.jpg',
        brand: 'test brand',
        category: 'test category',
        rating: 4,
        details: [{ keyText: 'test detail1', imgPath: 'test value1' }]
      },
      {
        document_id: '2',
        name: 'test2',
        price: 10,
        img: 'test.jpg',
        brand: 'test brand',
        category: 'test category',
        rating: 4,
        details: [{ keyText: 'test detail2', imgPath: 'test value2' }]
      }
    ];
    spyOn(searchService, 'getProductListMatchingSearchParam').and.returnValue(productList);
    component.ngOnInit();
    expect(component.searchKey).toEqual('test');
    expect(component.searchList).toEqual(productList);
    expect(searchService.getProductListMatchingSearchParam).toHaveBeenCalledWith('test', 'all');
  });
});