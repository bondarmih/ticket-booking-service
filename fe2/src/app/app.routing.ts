/* tslint:disable: max-line-length */
import { Routes } from '@angular/router';
import {MovieListComponent} from "./movie/movie-list/movie-list.component";
import { NotFound404Component } from './not-found404.component';
import {UserOutletComponent} from "./user-outlet/user-outlet.component";
import {AdminOutletComponent} from "./admin-outlet/admin-outlet.component";

export const routes: Routes = [
  { path: '', redirectTo: 'app', pathMatch: 'full'},
  { path: 'admin', component: AdminOutletComponent},
  { path: '**', component: NotFound404Component }
];
