import {ModuleWithProviders}  from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {AboutComponent} from './about/about.component';
import {MovieListComponent} from "./movie/movie-list/movie-list.component";
import {MovieDetailsComponent} from "./movie/movie-details/movie-details.component";

const appRoutes: Routes = [
    { path: '', component: MovieListComponent },
    { path: 'about', component: AboutComponent },
    { path: 'movies/:id', component: MovieDetailsComponent}

];

export const appRoutingProviders: any[] = [];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
