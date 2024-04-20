import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {AuthModel} from "../shared/auth.model";
import {AuthService} from "../services/auth.service";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrl: './auth.component.css'
})
export class AuthComponent implements OnInit{
  loginForm: FormGroup;

  constructor(private authService: AuthService) {
  }
  ngOnInit(): void {
    this.loginForm = new FormGroup({
      email: new FormControl(null),
      pwd: new FormControl(null)
    });
  }


  onLogin() {
    let email = this.loginForm.get('email').value;
    let pwd = this.loginForm.get('pwd').value;
    let auth: AuthModel = {email: email, password: pwd};
    this.authService.onLogin(auth);

  }
}
