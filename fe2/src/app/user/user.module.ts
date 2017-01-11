import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router'
import {FormsModule} from '@angular/forms'
import {BrowserModule} from '@angular/platform-browser';
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {AuthenticationService} from "./auth.service";
import {UserBar} from "./user-bar/user-bar.component";
import {UserService} from "./user.service";

let userRoutes: Routes = [
    { path: 'login', component: LoginComponent}
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
        RouterModule.forChild(userRoutes)
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
