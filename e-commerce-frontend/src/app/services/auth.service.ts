import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {Injectable} from "@angular/core";
import {AuthModel} from "../shared/auth.model";
import {Subject} from "rxjs";
import {UserModel} from "../shared/user.model";
import {AuthResponseModel} from "../shared/authResponse.model";

@Injectable()
export class AuthService {

  isAuthenticated = new Subject<boolean>();
  user: UserModel;

  constructor(private router: Router,
              private http: HttpClient) {
  }

 
  onLogin(auth: AuthModel, action: string) {
    auth.role = "USER";
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Action': action
      });

    console.log("Sending onLogin request for ", auth);
    this.http.post<AuthResponseModel>("http://localhost:8081/auth",auth, {headers})
      .subscribe(response => {
        console.log("Successfully logged in...",response.authToken, "expiresIn ",response.expiresIn);
        this.isAuthenticated.next(true);
        this.user = new UserModel(auth.emailId, response.authToken, response.expiresIn);
        localStorage.setItem('userData',JSON.stringify(this.user));
        this.autoLogout(response.expiresIn);
        this.router.navigate(["/products/mobile"]);
      }, error => {
        console.log("Error while logging in...", error);
        this.isAuthenticated.next(false);
      });

  }


  onLogOut() {
    //save cartList if any
    //clear index and indexData
    this.clearLocalStorage();
    this.user = null;
    this.router.navigate(["/login"]);
  }

  clearLocalStorage() {
    localStorage.removeItem('userData');
    localStorage.removeItem('item');
    localStorage.removeItem('itemIndex');
    localStorage.removeItem('searchItemIndex');
    localStorage.removeItem('searchItemData');

  }

  isUserLoggedIn() {
    const userData: {emailId: string, authToken: string, expiresIn: Date} = JSON.parse(localStorage.getItem('userData'));

    if (userData != null) {
      const u = new UserModel(userData.emailId, userData.authToken, userData.expiresIn);
      if (u.authToken) {
        return true;
      } else {
        return false;
      }
   }
  }



   autoLogin() {
    const userData: {emailId: string, authToken: string, expiresIn: Date} = JSON.parse(localStorage.getItem('userData'));

     if (userData != null) {
        const u = new UserModel(userData.emailId, userData.authToken, userData.expiresIn);
        if (u.authToken) {
          this.user = u;
          this.autoLogout(userData.expiresIn);
        }
     } else {
       this.router.navigate(["/login"]);
     }
  }

  autoLogout(expiresIn: Date) {
    let remainingTime = new Date(expiresIn).getTime() - new Date().getTime();
    setTimeout(() => {
      this.onLogOut();
    }, remainingTime);
  } 

  getUserData() {
    return this.user;
  }


}
