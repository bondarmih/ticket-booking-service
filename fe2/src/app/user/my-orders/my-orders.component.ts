/**
 * Created by bondarm on 15.01.17.
 */
import { Component, OnInit } from '@angular/core';
import {Order} from "../../order/order";
import {OrderService} from "../../order/order.service";
import 'rxjs/add/operator/switchMap';
import {UserService} from "../user.service";
import {User} from "../user";

@Component({
  moduleId: module.id,
  selector: 'user-orders',
  templateUrl: 'my-orders.component.html'
})
export class MyOrdersComponent implements OnInit {
  user: User;
  orders: Order[];
  constructor(
    private orderService: OrderService,
    private userService: UserService
  ) { }

  ngOnInit() {
    this.getUser();
  }

  private getUser() {
    this.userService.getUser()
      .subscribe(user => {
        this.user = user;
        this.getOrders(this.user.id);
      });
  }

  private getOrders(userId: number) {
    this.orderService.getOrdersByUserId(userId)
        .subscribe(orders => this.orders = orders);
  }
}

