import {User} from './user'
import { Injectable } from '@angular/core';
import {Http, Headers, Response, URLSearchParams, RequestOptions} from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map'
import {Subject} from 'rxjs/Subject'

let DEFAULT_USER = {
  id: 0,
  name: 'anonymous',
  dateOfBirth: new Date()
};

@Injectable()
export class UserService {

  private userUrl = 'api/users';
  private loginUrl = '/login';
  private isLoggedIn: boolean;
  private isLoggedInSubject: Subject<boolean>;

  constructor(private http: Http) {
    this.isLoggedInSubject = new Subject<boolean>();
  }

  get loggedInObservable() {
    return this.isLoggedInSubject.asObservable();
  }

  public login(username: string, password: string) {
    let headers = new Headers();
    headers.append('Content-Type', 'application/x-www-form-urlencoded');
    let urlSearchParams = new URLSearchParams();
    urlSearchParams.append('username', username);
    urlSearchParams.append('password', password);
    let body = urlSearchParams.toString();
    return this.http.post(this.loginUrl, body, {headers:headers})
      .map((response: Response) => {
        let user: User = JSON.parse(response.headers.get('user'));
        if(user) {
          localStorage.setItem('currentUser', JSON.stringify(user));
          this.isLoggedIn = true;
          this.isLoggedInSubject.next(this.isLoggedIn);
        }
      });
  }

  public logout() {
    localStorage.removeItem('currentUser');
    this.isLoggedIn = false;
    this.isLoggedInSubject.next(this.isLoggedIn);
  }

  public getUser(): Observable<User> {
    let user: User = JSON.parse(localStorage.getItem('currentUser')) as User;
    if (user) {
      return Observable.of(user);
    }
    user = DEFAULT_USER;
    return Observable.of(user);
  }

  // getUserById(): Observable<User> {
  //   return this.http.get(this.userUrl)
  //     .map((response: Response) => {
  //       let data = response.json;
  //       data.dateOfBirth = new Date(data.dateOfBirth);
  //       return data as User})
  //     .catch(this.handleError());
  // }

  public getUserByName(name: string): Observable<User> {
    let url = `${this.userUrl}/byName/${name}`;
    return this.http.get(url)
      .map(this.processUser)
      .catch(this.handleError);
  }

  private processUser(response: Response) {
    let data = response.json();
    if(data && data.dateOfBirth) {
      data.dateOfBirth = new Date(data.dateOfBirth);
      return data as User
    } else {
      return null;
    }
  }

  public addUser(name: string, password: string, dateOfBirth: Date): Observable<User> {
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    let user = {
      name: name,
      password: password,
      dateOfBirth: dateOfBirth
    };
    return this.http.put(this.userUrl, JSON.stringify(user), options)
      .map((response: Response) => {
        let data = response.json();
        data.dateOfBirth = new Date(data.dateOfBirth);
        return data as User;
      })
      .catch(this.handleError);
  }

  private handleError (error: Response | any) {
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }
}
