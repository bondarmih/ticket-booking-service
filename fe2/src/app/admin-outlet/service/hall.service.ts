/**
 * Created by bondarm on 15.01.17.
 */
import { Injectable } from '@angular/core';
import {Http, Headers, Response, RequestOptions} from '@angular/http';
import {Hall} from "../../movie/hall";
import {Observable} from "rxjs/Rx";
import 'rxjs/add/operator/map';


@Injectable()
export class HallService {

  hallsUrl: string = 'api/halls/';

  constructor(
    private http: Http,
  ) { }

  public getHalls(): Observable<Hall[]> {
    return this.http.get(this.hallsUrl)
      .map((response: Response) => {
        let data = response.json();
        return data as Hall[];
      })
      .catch(this.handleError)
  }

  public saveHall(hall: Hall): Observable<string> {
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    return this.http.post(this.hallsUrl, hall, options)
      .map((response: Response) => {
        return response.status;
      })
      .catch(this.handleError);
  }

  public deleteHall(id: number): Observable<string> {
    let url = `${this.hallsUrl}${id}`;
    return this.http.delete(url)
      .map((response: Response) => {
        return response.status;
      })
      .catch(this.handleError);
  }

  private handleError(error: Response | any) {
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
