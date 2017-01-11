import { UserActions } from './user/user.actions';
import { UserService } from './user/user.service';
import { LOCALE_ID } from '@angular/core';

export const APP_PROVIDERS = [
  UserActions,
  UserService,
  { provide: LOCALE_ID, useValue: "ru-RU" }
];
