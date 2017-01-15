/**
 * Created by bondarm on 14.01.17.
 */
import {Component, OnDestroy, OnInit} from '@angular/core';

import {User} from "../user";
import {UserService} from "../user.service";
import { Subscription }   from 'rxjs/Subscription';
import 'rxjs/Rx';
import {Router} from '@angular/router';
import 'rxjs/add/operator/map';

@Component({
  moduleId: 'module.id',
  selector: 'user-discounts',
  templateUrl: 'user-discounts.component.html',
  styleUrls: [ 'user-discounts.component.css']
})

export class UserDiscounts implements OnInit{
  discounts: string[]=[];
  isLoggedIn: boolean;
  subscription: Subscription;

  constructor(
              private userService: UserService,
              ) {
    this.subscription = this.userService.CurrentUserObservable
      .map((user: User) => {
        return (user != null)
      })
      .subscribe(val => {
      this.isLoggedIn = val;
      this.getDiscounts();

    });
  }

  ngOnInit(): void {
    this.userService.getUser()
      .map((user: User) => {
        return (user != null)
      })
      .subscribe(val => {
        this.isLoggedIn = val;
      });
    this.getDiscounts();
  }

  getDiscounts(): void {
    this.userService.getAvailableDiscountsForUser()
      .subscribe(discounts => this.discounts = discounts);

  }


}
