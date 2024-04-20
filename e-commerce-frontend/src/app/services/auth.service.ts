import {HttpClient} from "@angular/common/http";
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

  onLogin(auth: AuthModel) {

    this.http.post<AuthResponseModel>("http://localhost:8081/auth",auth)
      .subscribe(response => {
        console.log("Successfully logged in...");
        this.isAuthenticated.next(true);
        //this.isAuthenticated = true;
        const expiryDate = new Date(new Date().getTime() + +response.expiresIn * 1000);
        this.user = new UserModel(response.email, response.localId, response.idToken, expiryDate);
        localStorage.setItem('userData',JSON.stringify(this.user));
       // this.user.next(user);
        this.autoLogout(+response.expiresIn * 1000);
        this.router.navigate(["/products/mobile"]);

      }, error => {
        console.log("Error while logging in...", error.messageerror);
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

  autoLogin() {
    const userData: {email: string, id: string, _token: string, _tokenExpiryDate: string} = JSON.parse(localStorage.getItem('userData'));

     if (userData != null) {
        const u = new UserModel(userData.email,userData.id,userData._token,new Date(userData._tokenExpiryDate));
        if (u.token) {
          this.user = u;
          let remainingTime = new Date(userData._tokenExpiryDate).getTime() - new Date().getTime();
          this.autoLogout(remainingTime);
        }
     } else {
       this.router.navigate(["/login"]);
     }
  }

  autoLogout(expirationDuration: number) {
    setTimeout(() => {
      this.onLogOut();
    }, expirationDuration);
  }

  getUserData() {
    return this.user;
  }


}
