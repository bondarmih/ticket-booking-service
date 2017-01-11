/**
 * Created by bondarm on 09.01.17.
 */
import {NgModule} from '@angular/core'
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule, Routes} from '@angular/router'
import {FormsModule} from '@angular/forms';
import {SessionService} from "./session.service";
import {MovieService} from "./movie.service";
import {MovieDetailsComponent} from "./movie-details/movie-details.component";
import {MovieListComponent} from "./movie-list/movie-list.component";
import {SessionListComponent} from "./session-list/session-list.component";
import {SessionDetailsComponent} from "./session-details/session-details.component";
import {AfterDaySessions} from "./after-day-sessions.pipe";
import {ByDaySessions} from "./by-day-sessions.pipe";
import {OrderBySessions} from "./sort-by-date.pipe";
import {CommonModule} from "@angular/common";

let movieRoutes: Routes = [
  { path: '', component: MovieListComponent, pathMatch: 'full' },
  { path: 'movies/:id', component: MovieDetailsComponent}
];


@NgModule({
  declarations: [
    MovieDetailsComponent,
    MovieListComponent,
    SessionListComponent,
    SessionDetailsComponent,
    AfterDaySessions,
    ByDaySessions,
    OrderBySessions
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forChild(movieRoutes),
    CommonModule
  ],
  providers: [
    MovieService,
    SessionService
  ],
  exports: [
    RouterModule
  ]
})


export class MovieModule{

}
