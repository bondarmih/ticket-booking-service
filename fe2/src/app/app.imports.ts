import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule, PreloadAllModules } from '@angular/router';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { routes } from './app.routing';

import {UserModule} from "./user/user.module"

import {AdminModule} from "./admin-outlet/admin.module";


export const APP_IMPORTS = [
  NgbModule.forRoot(),
  ReactiveFormsModule,
  RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules }),
  UserModule,
  AdminModule
];

