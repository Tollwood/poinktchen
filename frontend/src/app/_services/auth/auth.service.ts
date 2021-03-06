import { Injectable } from '@angular/core';

import {
  Http,
  Headers,
  RequestOptions,
  Response
} from '@angular/http';

import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { environment } from '../../../environments/environment';
import {UserSignUp} from '../../_models/userSignUp';

/**
* AuthService uses JSON-Web-Token authorization strategy.
* Fetched token and user details are stored in localStorage.
*/
@Injectable()
export class AuthService {

  public static readonly SIGNUP_URL = environment.apiUrl + '/api/auth/signup';
  public static readonly SIGNIN_URL = environment.apiUrl + '/api/auth/signin';
  public static readonly REFRESH_TOKEN_URL = environment.apiUrl + '/api/auth/token/refresh';

  private token: string;
  private username: string;
  private userId: number;

  constructor(private http: Http) {
    this.refreshUserData();
  }

  /**
  * Refreshes userId, username and token from localStorage
  */
  public refreshUserData(): void {
    const user = localStorage.getItem('user');
    if (user) {
      this.saveUserDetails(JSON.parse(user));
    }
  }

  /**
  * Registers new user and saves following token
  * @param username
  * @param email
  * @param password
  */
  public signUp(user: UserSignUp): Observable<{}> {

    return this.http.post(AuthService.SIGNUP_URL, user, this.generateOptions())
      .map((res: Response) => {
        this.saveToken(res);
        this.saveUserDetails(JSON.parse(localStorage.getItem('user')));
      }).catch(err => {
        throw Error(err.json().message);
      });
  }

  /**
  * Fetches and saves token for given user
  * @param username
  * @param password
  */
  public signIn(username: string, password: string): Observable<{}> {

    const requestParam = {
      username: username,
      password: password
    };

    return this.http.post(AuthService.SIGNIN_URL, requestParam, this.generateOptions())
      .map((res: Response) => {
        this.saveToken(res);
        this.saveUserDetails(JSON.parse(localStorage.getItem('user')));
      }).catch(err => {
        throw Error(err.json().message);
      });
  }

  /**
  * Removes token and user details from localStorage and service's variables
  */
  public logout(): void {
    localStorage.removeItem('user');
    this.token = null;
    this.username = null;
    this.userId = null;
  }

  /**
  * Refreshes token for the user with given token
  * @param token - which should be refreshed
  */
  public refreshToken(token: string): Observable<{}> {
    const requestParam = { token: this.token };

    return this.http.post(AuthService.REFRESH_TOKEN_URL, requestParam, this.generateOptions())
      .map((res: Response) => {
         this.saveToken(res);
      }).catch(err => {
        throw Error(err.json().message);
      });
  }

  /**
  * Checks if user is authorized
  * @return true is user authorized (there is token in localStorage) else false
  */
  public isAuthorized(): boolean {
    return Boolean(this.token);
  }

  /**
  * @return username if exists
  */
  public getUsername(): string {
    return this.username;
  }

  /**
  * @return userId if exists
  */
  public getUserId(): number {
    return this.userId;
  }

  /**
  * @return token if exists
  */
  public getToken(): string {
    return this.token;
  }

  // Saves user details with token into localStorage as user item
  private saveToken(res: Response): void {
    const response = res.json() && res.json().token;
    if (response) {
            const token = response;
            let claims = this.getTokenClaims(token);
            claims.token = token;
            localStorage.setItem('user', JSON.stringify(claims));
    } else {
      throw Error(res.json());
    }
  }

  // Saves user details into service properties
  private saveUserDetails(user): void {
    this.token = user.token || '';
    this.username = user.sub || '';
    this.userId = user.id || 0;
  }

  // Retrieves user details from token
  private getTokenClaims(token: string): any {
    const base64Url = token.split('.')[1];
    const base64 = base64Url.replace('-', '+').replace('_', '/');
    return JSON.parse(window.atob(base64));
  }

  // Generates Headers
  private generateOptions(): RequestOptions {
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('Access-Control-Allow-Origin', '*');
    headers.append('Access-Control-Allow-Headers', 'Origin, Authorization, Content-Type');
    return new RequestOptions({ headers: headers });
  }

}
