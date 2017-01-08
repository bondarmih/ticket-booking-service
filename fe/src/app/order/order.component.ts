import {Component, OnInit} from '@angular/core';

import {Order} from "./order";
import {Session} from "../session/session";
import {UserService} from "../user/user.service";
import {User} from "../user/user";
import {SessionService} from "../session/session.service";
import {ActivatedRoute, Params} from '@angular/router'
import 'rxjs/add/operator/switchMap';



@Component({
    moduleId: 'module.id',
    selector: 'my-order',
    template: require('./order.component.html'),
    styles: [ require('./order.component.css')]
})

export class OrderComponent implements OnInit{
    private order: Order;
    private user: User;
    private session: Session;

    constructor(
        private userService: UserService,
        private sessionService: SessionService,
        private route: ActivatedRoute
    ) {
        //get session

    }

    ngOnInit() {
        console.log('order constructor')
        this.route.params.switchMap((params: Params) => this.sessionService.getSessionById(+params['sessionId']))
            .subscribe(session => {
                this.session = session;
                console.log('session:' + JSON.stringify(this.session));
            });
        //get user
        this.userService.getUser()
            .subscribe(user => this.user = user);
        console.log('user' + JSON.stringify(this.user));
        //new order
        this.order = new Order(this.session, this.user);
    }

}
