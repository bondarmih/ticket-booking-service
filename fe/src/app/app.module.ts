import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {HttpModule, JsonpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {routing, appRoutingProviders} from './app.routing';
import {HomeComponent} from './home/home.component';
import {AboutComponent} from './about/about.component';
import {MovieListComponent} from "./movie/movie-list/movie-list.component";
import {MovieService} from "./services/movie.service";
import {MovieDetailsComponent} from "./movie/movie-details/movie-details.component";
import {SessionListComponent} from "./session/session-list/session-list.component";
import {SessionService} from "./services/session.service";
import {ByDaySessions} from "./pipes/by-day-sessions.pipe";
import {SessionDetailsComponent} from "./session/session-details/session-details.component";
import {AfterDaySessions} from "./pipes/after-day-sessions.pipe";
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {AuthenticationService} from "./services/auth.service";
import {APP_BASE_HREF} from "@angular/common";

@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        AboutComponent,
        MovieListComponent,
        MovieDetailsComponent,
        SessionListComponent,
        SessionDetailsComponent,
        ByDaySessions,
        AfterDaySessions,
        LoginComponent,
        RegisterComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        JsonpModule,
        routing
    ],
    providers: [
        appRoutingProviders,
        MovieService,
        SessionService,
        AuthenticationService,
        {provide: APP_BASE_HREF, useValue: '/ticket-booking-service'}
    ],
    bootstrap: [AppComponent]
})

export class AppModule {
}
