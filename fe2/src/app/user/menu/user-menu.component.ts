/**
 * Created by bondarm on 14.01.17.
 */
import {Component} from '@angular/core';

@Component({
  moduleId: 'module.id',
  selector: 'user-menu',
  templateUrl: 'user-menu.component.html',
  styleUrls: ['user-menu.component.css']
})

export class UserMenu {
  isAdmin: boolean = false;
}
