import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {SearchService} from "../services/search.service";
import {AuthService} from "../services/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit{
  searchForm: FormGroup;
  isLoggedIn: boolean;

  ngOnInit(): void {
    this.searchForm = new FormGroup({
      'searchInput': new FormControl(null)
    });
    if (this.authService.getUserData() != null) {
      this.isLoggedIn = true;
    }

    this.authService.isAuthenticated.subscribe(val => {
      this.isLoggedIn = val;
    });
  }

  constructor(private searchService: SearchService,
              private authService: AuthService) {
  }


  onSearchSubmit() {
    this.searchService.displayMatchingList(this.searchForm.get('searchInput').value.toString());
  }

  onLogout() {
    this.authService.onLogOut();
    this.isLoggedIn = false;
  }
}
