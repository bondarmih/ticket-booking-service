import {Component, OnInit} from '@angular/core';

import {Order} from "./order";
import {ActivatedRoute, Params} from '@angular/router'
import 'rxjs/add/operator/switchMap';
import {OrderService} from "./order.service";



@Component({
  moduleId: 'module.id',
  selector: 'my-order',
  templateUrl: 'order.component.html',
  styleUrls: ['order.component.css']
})

export class OrderComponent implements OnInit{
  private order: Order;
  private submitted = false;
  private ticketsAvailable: number;
  constructor(
    private orderService: OrderService,
    private route: ActivatedRoute
  ) {}

  onSubmit(): void {
    this.submitted = true;
    this.orderService.addOrder(this.order)
      .subscribe(order => this.order = order);

  }

  onChange(): void {

    let isVip = this.order.vip;
    let s = this.order.session;
    let price =
      (isVip
        ?
        (s.priceVipDiscount > 0 ? s.priceVipDiscount : s.priceVip)
        :
        (s.priceRegDiscount > 0 ? s.priceRegDiscount : s.priceReg));

    this.order.price = price * this.order.ticketsCount;

    this.ticketsAvailable = (isVip? s.vipSeatsAvailable : s.regSeatsAvailable);
  }

  vipChange(vip) {
    this.order.vip = vip;
  }

  getNewOrder(): void {
    this.route.params.switchMap((params: Params) => this.orderService.getNewOrderWithSessionId(+params['sessionId']))
      .subscribe(order => {this.order = order; this.ticketsAvailable = order.session.regSeatsAvailable});
  }

  ngOnInit() {
    this.getNewOrder();


  }
}
