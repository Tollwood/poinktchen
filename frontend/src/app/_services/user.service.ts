import { Injectable } from '@angular/core';
import {Headers, Http, Response} from '@angular/http';
import { User } from '../_models/user';
import 'rxjs/add/operator/toPromise';

import { environment } from '../../environments/environment';

@Injectable()
export class UserService {

    public static readonly USER_URL = environment.apiUrl + '/api/users';
    public static readonly USER_SLASH_URL = environment.apiUrl + '/api/users/';
    constructor(private http: Http) { }

    getById (id: number): Promise<User> {
        return this.http
            .get(UserService.USER_SLASH_URL + id, this.jwt())
            .toPromise()
            .then((response: Response) => {
                return response.json() as User;
            });
    }

    getAllUser(): Promise<User[]> {
        return this.http.get(UserService.USER_URL, this.jwt())
            .toPromise()
            .then((res) => {
            return res.json() as User[];
        });

    }

    private jwt() {
        // create authorization header with jwt token
        let currentUser = JSON.parse(localStorage.getItem('user'));
        if (currentUser && currentUser.token) {
            let headers = new Headers({ 'Authorization': currentUser.token });
            return { headers: headers };
        }
    }


}
