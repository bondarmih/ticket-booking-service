import { UserService } from './user/user.service';
import { LOCALE_ID } from '@angular/core';

export const APP_PROVIDERS = [
  UserService,
  { provide: LOCALE_ID, useValue: "ru-RU" }
];
