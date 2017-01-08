/**
 * Created by bondarm on 02.01.17.
 */


import { Injectable } from '@angular/core';
import {Session} from "./session";
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map'
import {Observable} from 'rxjs/Rx';

@Injectable()
export class SessionService {

    private getSessionsByMovieUrl = 'sessions/byMovieId';
    private getSessionUrl = 'sessions'

    constructor(
       private http: Http
    ){}

    public getSessionsByMovieId(movieId: number): Observable<Session[]> {
        const url = `${this.getSessionsByMovieUrl}/${movieId}`;
        return this.http.get(url).map((response: Response) => {
            let data = response.json() as Session[]|| [];
            data.forEach((session: Session) => {
                session.timeStart = new Date(session.timeStart);
            })
            return data;

        })
            .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
    }

    // public getSes(movieId: number): Observable<Session[]> {
    //     let ses = sessions.filter((session : Session) => session.movieId === movieId);
    //     return Observable.of(ses);
    // }

    public getSessionById(id: number): Observable<Session> {
        const url = `${this.getSessionUrl}/${id}`;
        return this.http.get(url).map((response: Response) => {
            let data = response.json() as Session;
            data.timeStart = new Date(data.timeStart);
            return data;
        })
            .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
    }

    // public getSe(id: number): Observable<Session> {
    //     let ses = sessions.filter((session : Session) => session.id === id);
    //     return Observable.of(ses.);
    // }

}
