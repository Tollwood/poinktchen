import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { AuthService } from '../_services/auth/auth.service';
import { AlertService } from '../_services/alert.service';
import {UserSignUp} from '../_models/userSignUp';

@Component({
    moduleId: module.id.toString(),
    templateUrl: 'register.component.html'
})

export class RegisterComponent {
    model: UserSignUp = new UserSignUp();
    loading = false;

    constructor(
        private router: Router,
        private authService: AuthService,
        private alertService: AlertService) { }

    register() {
        this.loading = true;
        this.authService.signUp(this.model)
            .subscribe(
                data => {
                    this.alertService.success('Registration successful', true);
                    this.router.navigate(['/login']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}