import {Component, OnInit} from '@angular/core';
import {User} from "./user";
import {UserService} from "./user.service";

import './rxjs-extensions';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit{

  constructor(private userService: UserService) {}
  users: User[];
  selectedUser: User;

  onSelect(user: User): void {
    this.selectedUser = user;
  }

  getUsers(): void {
    this.userService
      .getUsers()
      .then(users => this.users = users);
  }

  ngOnInit(): void {
    this.getUsers();
  }
  title = 'Users list';

}
