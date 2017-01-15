import {User} from './user'
import { Injectable } from '@angular/core';
import {Http, Headers, Response, URLSearchParams, RequestOptions} from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import {Subject} from 'rxjs/Subject';
import { Cookie } from 'ng2-cookies/ng2-cookies';


@Injectable()
export class UserService {

  private userUrl = 'api/users/';
  private loginUrl = 'api/login';
  private UserSubject: Subject<User>;
  private user: User;

  constructor(private http: Http) {
    this.UserSubject = new Subject<User>();
    localStorage.removeItem('currentUser');
  }

  get CurrentUserObservable() {
    return this.UserSubject.asObservable();
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

          this.UserSubject.next(user);
        }
      });
  }

  public logout(): Observable<Response> {

    return this.http.post('logout',{})
      .map((response: Response) => {
        this.UserSubject.next(null);
        localStorage.removeItem('currentUser');
        Cookie.deleteAll();
        return response;
      });

  }

  public getUser(): Observable<User> {
    let userString = localStorage.getItem('currentUser');
    if (userString) {
      let user: User = JSON.parse(userString);
      return Observable.of(user);
    }

    let url = `${this.userUrl}getCurrentUser`;
    return this.http.get(url)
      .map(this.processUser)
      .catch(this.handleError);
  }

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

  public getAvailableDiscountsForUser(): Observable<string[]> {
    let url = `${this.userUrl}discounts`;
    return this.http.get(url)
      .map((response: Response) =>
        response.json() as string[])
      .catch(this.handleError);
  }


  public addUser(name: string, password: string, dateOfBirth: Date): Observable<number> {
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    let user = {
      name: name,
      password: password,
      dateOfBirth: dateOfBirth
    };
    return this.http.put(this.userUrl, JSON.stringify(user), options)
      .map((response: Response) => {
        return response.ok;
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
