import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router'
import {FormsModule, ReactiveFormsModule} from '@angular/forms'
import {BrowserModule} from '@angular/platform-browser';
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {AuthenticationService} from "./auth.service";
import {UserBar} from "./user-bar/user-bar.component";
import {UserService} from "./user.service";
import {DateValueAccessorModule} from 'angular-date-value-accessor';
import {UserDiscounts} from "./user-discounts/user-discounts.component";
import {UserMenu} from "./menu/user-menu.component";
import {MyOrdersComponent} from "./my-orders/my-orders.component";
import {UserOutletComponent} from "../user-outlet/user-outlet.component";
import {MovieModule} from "../movie/movie.module";
import {MovieListComponent} from "../movie/movie-list/movie-list.component";
import {MovieDetailsComponent} from "../movie/movie-details/movie-details.component";
import {OrderModule} from "../order/order.module";
import {OrderComponent} from "../order/order.component";

let userRoutes: Routes = [
  {
    path: 'app', component: UserOutletComponent,
    children: [
      {path: '', component: MovieListComponent},
      {path: 'movies/:id', component: MovieDetailsComponent},
      {path: 'movies/filter/:tag', component: MovieListComponent},
      {path: 'orders/withSession/:sessionId', component: OrderComponent}
    ]
  },
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'login?logout', component: LoginComponent},
  {path: 'myOrders', component: MyOrdersComponent}
];

@NgModule({
  declarations: [
    LoginComponent,
    RegisterComponent,
    UserBar,
    UserDiscounts,
    UserMenu,
    MyOrdersComponent,
    UserOutletComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forChild(userRoutes),
    DateValueAccessorModule,
    MovieModule,
    OrderModule
  ],
  providers: [
    AuthenticationService,
    UserService
  ],
  exports: [
    RouterModule,
    UserBar,
    UserMenu,
    UserOutletComponent
  ]
})

export class UserModule{

}
