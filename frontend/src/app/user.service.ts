import { Injectable } from '@angular/core';
import {User} from "./user";
import {Http} from "@angular/http";

import 'rxjs/add/operator/toPromise';

@Injectable()
export class UserService {

  private getAllUsersUrl = 'users/all';

  constructor(private http: Http) { }

  getUsers(): Promise<User[]> {
    return this.http.get(this.getAllUsersUrl)
      .toPromise()
      .then(response => response.json() as User[])
      //.then(response => console.log(response.json()))
      .catch(this.handleError);
  }


  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
