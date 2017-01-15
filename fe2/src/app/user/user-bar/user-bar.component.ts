import {Component, OnDestroy, OnInit} from '@angular/core';

import {User} from "../user";
import {UserService} from "../user.service";
import { Subscription }   from 'rxjs/Subscription';
import 'rxjs/Rx';
import {Router} from '@angular/router';

@Component({
    moduleId: 'module.id',
    selector: 'user-bar',
    templateUrl: 'user-bar.component.html',
    styleUrls: [ 'user-bar.component.css']
})

export class UserBar implements OnDestroy, OnInit {
    user: User;
    subscription: Subscription;
    private returnUrl = '/';

    constructor(
        private userService: UserService,
        private router: Router
    ){
      this.subscription = this.userService.CurrentUserObservable.subscribe(user => {
        this.user = user;
      });
    }

  ngOnDestroy(): void {
      this.subscription.unsubscribe();
  }

  ngOnInit(): void {
    this.userService.getUser()
      .subscribe(user => this.user = user);
  }

  onLogout(): void {
    this.userService.logout()
      .subscribe(data => this.router.navigate([this.returnUrl]));

  }

}
