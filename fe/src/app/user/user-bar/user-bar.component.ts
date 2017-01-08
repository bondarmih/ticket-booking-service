import {Component, OnDestroy, OnInit} from '@angular/core';
import {User} from "../user";
import {UserService} from "../user.service";
import { Subscription }   from 'rxjs/Subscription';
import 'rxjs/Rx'

@Component({
    moduleId: 'module.id',
    selector: 'user-bar',
    template: require('./user-bar.component.html'),
    styles: [ require('./user-bar.component.css')]
})

export class UserBar implements OnDestroy {
    user: User;
    isLoggedIn: boolean = false;
    subscription: Subscription;

    constructor(
        private userService: UserService,

    ){
        this.subscription = this.userService.loggedInObservable.subscribe(val => {
            this.isLoggedIn = val;
            this.getUser();
        });
    }

    getUser(): void {
        this.userService.getUser()
            .subscribe(user => this.user = user);

    }

  ngOnDestroy(): void {
      this.subscription.unsubscribe();
  }

  ngOnInit(): void {
      this.getUser();
  }

}
