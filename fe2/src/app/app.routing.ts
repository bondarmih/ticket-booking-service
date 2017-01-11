/* tslint:disable: max-line-length */
import { Routes } from '@angular/router';
import {MovieListComponent} from "./movie/movie-list/movie-list.component";
import { NotFound404Component } from './not-found404.component';

export const routes: Routes = [
  { path: '**', component: NotFound404Component }
];
