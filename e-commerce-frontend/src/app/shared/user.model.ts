export class UserModel {

  /* constructor(public email: string,
              public id: string,
              private _token: string,
              private _tokenExpiryDate: Date) {}

  get token() {
    if (!this._tokenExpiryDate || new Date() > this._tokenExpiryDate) {
      return null;
    }
    return this._token;
  } */
 constructor(public email: string,public authToken: string) {}

}
