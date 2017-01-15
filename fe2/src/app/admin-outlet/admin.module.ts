/**
 * Created by bondarm on 15.01.17.
 */
import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule, Routes} from '@angular/router'
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CommonModule} from "@angular/common";
import {AdminOutletComponent}   from './admin-outlet.component';
import {AdminDashboardComponent} from "./dashboard/dashboard.component";
import {AdminHallListComponent} from "./hall/hall-list/hall-list.component";
import {MovieModule} from "../movie/movie.module";
import {UserModule} from "../user/user.module";
import {OrderModule} from "../order/order.module";
import {HallService} from "./service/hall.service";
import {AdminHallDetailsComponent} from "./hall/hall-details/hall-details.component";
import {AdminMovieListComponent} from "./movie/movie-list/movie-list.component";
import {AdminMovieDetailsComponent} from "./movie/movie-details/movie-details.component";
import {AdminSessionListComponent} from "./session/session-list/session-list.component";
import {AdminSessionDetailsComponent} from "./session/session-details/session-details.component";

export const adminRoutes: Routes = [
  {path: 'admin', component: AdminOutletComponent,
    children: [
      {path: 'halls', component: AdminHallListComponent},
      {path: 'movies', component: AdminMovieListComponent},
      {path: 'sessions', component: AdminSessionListComponent}
    ]
  }
];


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forChild(adminRoutes),
    CommonModule
  ],
  exports: [RouterModule,
  AdminOutletComponent],
  declarations: [
    AdminOutletComponent,
    AdminDashboardComponent,
    AdminHallListComponent,
    AdminHallDetailsComponent,
    AdminMovieListComponent,
    AdminMovieDetailsComponent,
    AdminSessionListComponent,
    AdminSessionDetailsComponent
  ],
  providers: [
    HallService
  ],
})



export class AdminModule {
}
