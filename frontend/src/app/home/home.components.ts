import { Component, OnInit } from '@angular/core';

import { User } from '../_models/user';
import { UserService } from '../_services/user.service';
import {AuthService} from '../_services/auth/auth.service';

@Component({
    moduleId: module.id.toString(),
    templateUrl: 'home.component.html'
})

export class HomeComponent implements OnInit {
    currentUser: User = new User(null, null, null);
    users: User[] = [];

    constructor(private userService: UserService, private authService: AuthService) {

    }

    ngOnInit() {
       this.userService.getById(this.authService.getUserId())
           .then((user: User) => {
                   this.currentUser = user;
           });
        this.userService.getAllUser()
            .then((fetchedUsers: User[]) => {
                this.users = fetchedUsers;
            });

    }
}
