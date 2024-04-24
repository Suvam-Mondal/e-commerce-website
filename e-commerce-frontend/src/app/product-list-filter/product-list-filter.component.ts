import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {faBorderAll, faList} from "@fortawesome/free-solid-svg-icons";
import {Subject} from "rxjs";
import {ProductService} from "../services/product.service";
import {Event} from "@angular/router";

@Component({
  selector: 'app-product-list-filter',
  templateUrl: './product-list-filter.component.html',
  styleUrl: './product-list-filter.component.css'
})
export class ProductListFilterComponent implements OnInit , AfterViewInit {

  protected readonly faBorderAll = faBorderAll;
  protected readonly faList = faList;
  isDisplayAsList: boolean;
  @ViewChild('sortSelect') sortSelect: ElementRef<HTMLSelectElement>;


  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.isDisplayAsList = this.productService.getStoredDisplayToggleValue();
  }

  ngAfterViewInit(): void {
    this.sortSelect.nativeElement.value = this.productService.getStoredSortByValue();
  }


  onChangeListView() {
    this.isDisplayAsList = !this.isDisplayAsList;
    this.productService.updateDisplayListToggle(this.isDisplayAsList);

  }

  onSortOptionSelected($event: Event) {
    this.productService.sortList((<HTMLSelectElement>event.target).value);
  }


}
