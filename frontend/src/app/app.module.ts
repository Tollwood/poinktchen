import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { AuthService } from './_services/auth/auth.service';
import {AlertComponent} from './_directives/alert.component';
import {HomeComponent} from './home/home.components';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {AuthGuard} from './_guards/auth.guard';
import {AlertService} from './_services/alert.service';
import {UserService} from './_services/user.service';
import {routing} from './app.routing';

@NgModule({
  declarations: [
    AppComponent,
    AlertComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [
    AuthService,
    AuthGuard,
    AlertService,
    UserService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
