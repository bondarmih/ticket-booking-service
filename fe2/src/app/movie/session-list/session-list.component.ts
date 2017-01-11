import {Component, Input, OnInit} from "@angular/core";
import {Session} from "../session";
import {SessionService} from "../session.service";



@Component({
    moduleId: 'module.id',
    selector: 'session-list',
    templateUrl: 'session-list.component.html',
    styleUrls: ['session-list.component.css']
})

export class SessionListComponent implements OnInit{
    sessions: Session[] = [];
    @Input() movieId: number;
    private today: Date;
    private tomorrow: Date;
    private afterTomorrow: Date;

    constructor (
        private sessionService: SessionService
    ) {
        this.today = new Date;
        this.tomorrow = new Date();
        this.tomorrow.setHours(0,0,0,0);
        this.tomorrow.setDate(this.tomorrow.getDate() + 1);
        this.afterTomorrow = new Date();
        this.afterTomorrow.setHours(0,0,0,0);
        this.afterTomorrow.setDate(this.afterTomorrow.getDate() + 2);
    }

    private getSessionsByMovieId(movieId: number) {
        this.sessionService.getSessionsByMovieId(movieId).subscribe(sessions => this.sessions = sessions);
    }

    ngOnInit() {
        this.getSessionsByMovieId(this.movieId);
    }
}
