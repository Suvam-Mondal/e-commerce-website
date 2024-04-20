import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ProductModel} from "../shared/product.model";
import {SearchService} from "../services/search.service";

@Component({
  selector: 'app-search-list',
  templateUrl: './search-list.component.html',
  styleUrl: './search-list.component.css'
})
export class SearchListComponent implements OnInit {

  searchKey: string;
  searchCategory: string = 'all';
  searchList: ProductModel[];

  constructor(private activatedRoute: ActivatedRoute,
              private searchService: SearchService) {
  }

  ngOnInit(): void {
    this.activatedRoute.queryParamMap.subscribe(paramMap => {
      this.searchKey = paramMap.get('searchKey');
      this.searchList = this.searchService.getProductListMatchingSearchParam(this.searchKey, this.searchCategory);

    });
  }


}
