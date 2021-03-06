import {Injectable} from "@angular/core";
import {Order} from "./order";
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map'



@Injectable()
export class OrderService {

  private getNewOrderUrl = 'api/orders/new';
  private ordersUrl = 'api/orders/';

  constructor(
    private http: Http
  ){}

  public getNewOrderWithSessionId(sessionId: number): Observable<Order> {
    const url = `${this.getNewOrderUrl}/${sessionId}`;
    return this.http.get(url)
      .map(this.processRequest)
      .catch(this.handleError);
  }

  public addOrder(order: Order): Observable<Order> {
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    return this.http.put(this.ordersUrl, JSON.stringify(order), options)
      .map(this.processRequest)
      .catch(this.handleError);
  }

  public getOrdersByUserId(userId: number): Observable<Order[]> {
    let url = `${this.ordersUrl}byUserId/${userId}`;
    return this.http.get(url)
      .map((response: Response)=> {
        let orders = response.json();
        orders.forEach(order=> {
          order.session.timestart = new Date(order.session.timestart);
          order.session.movie.starting = new Date(order.session.movie.starting);
          order.user.dateOfBirth = new Date(order.user.dateOfBirth);
          order.date = new Date(order.date);
          return order as Order;
        });
        return orders as Order[];
      })
      .catch(this.handleError);
  }

  private processRequest(response: Response) {
  let data = response.json();
    data.session.timeStart = new Date(data.session.timeStart);
    data.session.movie.starting = new Date(data.session.movie.starting);
    data.user.dateOfBirth = new Date(data.user.dateOfBirth);
    data.date = new Date(data.date);
  return data as Order;
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
