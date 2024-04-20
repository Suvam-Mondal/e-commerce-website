import {async, ComponentFixture, TestBed} from '@angular/core/testing';
import {ReactiveFormsModule} from '@angular/forms';
import {HeaderComponent} from './header.component';
import {SearchService} from '../services/search.service';
import {ProductService} from "../services/product.service";
import {HttpClientModule} from "@angular/common/http";
import {AuthService} from "../services/auth.service";

describe('HeaderComponent', () => {
  let component: HeaderComponent;
  let fixture: ComponentFixture<HeaderComponent>;
  let searchService: SearchService;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeaderComponent ],
      imports: [ ReactiveFormsModule, HttpClientModule ],
      providers: [
        SearchService,
        { provide: ProductService, useClass: ProductService }, // Provide ProductService
        { provide: AuthService, useClass: AuthService } // Provide AuthService

      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderComponent);
    component = fixture.componentInstance;
    searchService = TestBed.inject(SearchService);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should initialize searchForm correctly', () => {
    expect(component.searchForm).toBeDefined();
    expect(component.searchForm.get('searchInput')).toBeDefined();
  });

  it('should call searchService onSearchSubmit', () => {
    const searchValue = 'test';
    spyOn(searchService, 'displayMatchingList');

    component.searchForm.patchValue({ searchInput: searchValue });
    component.onSearchSubmit();

    expect(searchService.displayMatchingList).toHaveBeenCalledWith(searchValue);
  });
});
