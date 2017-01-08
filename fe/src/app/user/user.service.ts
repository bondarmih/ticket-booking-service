import {User} from './user'
import { Injectable } from '@angular/core';
import {Http, Headers, Response, URLSearchParams} from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'
import {Subject} from 'rxjs/Subject'

let DEFAULT_USER = {
    id: 0,
    name: 'anonymous',
    password: 'aaa'
};

@Injectable()
export class UserService {


    private isLoggedIn: boolean;

    private isLoggedInSubject: Subject<boolean>;

    constructor(private http: Http) {
        this.isLoggedInSubject = new Subject<boolean>();
    }

    get loggedInObservable() {
        return this.isLoggedInSubject.asObservable();
    }

    login(username: string, password: string) {
        let headers = new Headers();
        headers.append('Content-Type', 'application/x-www-form-urlencoded');
        let urlSearchParams = new URLSearchParams();
        urlSearchParams.append('username', username);
        urlSearchParams.append('password', password);
        let body = urlSearchParams.toString();
        return this.http.post('/ticket-booking-service/login', body, {headers:headers})
            .map((response: Response) => {
                let user: User = JSON.parse(response.headers.get('user'));
                if(user) {
                    localStorage.setItem('currentUser', JSON.stringify(user));
                    this.isLoggedIn = true;
                    this.isLoggedInSubject.next(this.isLoggedIn);
                }
            });
    }

    logout() {
        localStorage.removeItem('currentUser');
        this.isLoggedIn = false;
        this.isLoggedInSubject.next(this.isLoggedIn);
    }

    getUser(): Observable<User> {
        let user: User = JSON.parse(localStorage.getItem('currentUser')) as User;
        if (user) {
            return Observable.of(user);
        }
        user = DEFAULT_USER;
        return Observable.of(user);
    }
}
