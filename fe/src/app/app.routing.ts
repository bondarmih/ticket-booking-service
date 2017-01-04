import {ModuleWithProviders}  from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {HomeComponent} from './home/home.component';
import {AboutComponent} from './about/about.component';
import {MovieListComponent} from "./movie/movie-list/movie-list.component";
import {MovieDetailsComponent} from "./movie/movie-details/movie-details.component";
import {LoginComponent} from "./login/login.component";

const appRoutes: Routes = [
    { path: '', component: MovieListComponent },
    { path: 'about', component: AboutComponent },
    { path: 'movies/:id', component: MovieDetailsComponent},
    { path: 'login', component: LoginComponent}
];

export const appRoutingProviders: any[] = [];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
