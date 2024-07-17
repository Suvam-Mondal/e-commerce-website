import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup } from "@angular/forms";
import { AuthModel } from "../shared/auth.model";
import { AuthService } from "../services/auth.service";
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrl: './auth.component.css'
})
export class AuthComponent implements OnInit, OnDestroy {
  loginForm: FormGroup;
  isAuthenticatedSubscriber = new Subscription();
  isLoginFailure: boolean;


  constructor(private authService: AuthService,
    private router: Router
  ) {
  }
  ngOnInit(): void {
    this.checkIfUserLoggedIn();
    this.loginForm = new FormGroup({
      email: new FormControl(null),
      pwd: new FormControl(null)
    });
  }

  checkIfUserLoggedIn() {
    if (this.authService.isUserLoggedIn()) {
      this.router.navigate(["/products/mobile"]);
    }

  }


  onLogin() {

    let email = this.loginForm.get('email').value;
    let pwd = this.loginForm.get('pwd').value;
    let auth: AuthModel = { emailId: email, password: pwd, role: 'USER' };
    this.authService.onLogin(auth, "action_login");
    
    /* this.isAuthenticatedSubscriber = this.authService.isAuthenticated.subscribe(val => {
      this.isLoginFailure = !val;
      console.log("onLogin()::isLoginFailure ", !val);

    }) */
  }

  onSignup() {
    let email = this.loginForm.get('email').value;
    let pwd = this.loginForm.get('pwd').value;
    let auth: AuthModel = { emailId: email, password: pwd, role: 'USER' };
    this.authService.onLogin(auth, "action_signup");
    this.isAuthenticatedSubscriber = this.authService.isAuthenticated.subscribe(val => {
      this.isLoginFailure = !val;
      console.log("onSignup()::isLoginFailure ", !val);
    })
  }

  ngOnDestroy(): void {
    this.isAuthenticatedSubscriber.unsubscribe();
  }
}
