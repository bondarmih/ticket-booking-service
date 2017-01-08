import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {HttpModule, JsonpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {routing, appRoutingProviders} from './app.routing';
import {AboutComponent} from './about/about.component';
import {MovieListComponent} from "./movie/movie-list/movie-list.component";
import {MovieService} from "./movie/movie.service";
import {MovieDetailsComponent} from "./movie/movie-details/movie-details.component";
import {SessionListComponent} from "./session/session-list/session-list.component";
import {SessionService} from "./session/session.service";
import {ByDaySessions} from "./session/by-day-sessions.pipe";
import {SessionDetailsComponent} from "./session/session-details/session-details.component";
import {AfterDaySessions} from "./session/after-day-sessions.pipe";
import {OrderBySessions} from "./session/sort-by-date.pipe";
import {APP_BASE_HREF} from "@angular/common";
import {UserModule} from "./user/user.module"
import {OrderModule} from "./order/order.module";

@NgModule({
    declarations: [
        AppComponent,
        AboutComponent,
        MovieListComponent,
        MovieDetailsComponent,
        SessionListComponent,
        SessionDetailsComponent,
        ByDaySessions,
        AfterDaySessions,
        OrderBySessions
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        JsonpModule,
        routing,
        UserModule,
        OrderModule
    ],
    providers: [
        appRoutingProviders,
        MovieService,
        SessionService
    ],
    bootstrap: [AppComponent]
})

export class AppModule {
}
