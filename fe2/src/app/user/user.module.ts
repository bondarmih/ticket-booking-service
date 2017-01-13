import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router'
import {FormsModule, ReactiveFormsModule} from '@angular/forms'
import {BrowserModule} from '@angular/platform-browser';
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {AuthenticationService} from "./auth.service";
import {UserBar} from "./user-bar/user-bar.component";
import {UserService} from "./user.service";
import { DateValueAccessorModule } from 'angular-date-value-accessor';


let userRoutes: Routes = [
  { path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent}
];

@NgModule({
  declarations: [
    LoginComponent,
    RegisterComponent,
    UserBar
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forChild(userRoutes),
    DateValueAccessorModule
  ],
  providers: [
    AuthenticationService,
    UserService
  ],
  exports: [
    RouterModule,
    UserBar
  ]
})

export class UserModule{

}
