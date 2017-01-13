import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule, PreloadAllModules } from '@angular/router';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { routes } from './app.routing';

import {UserModule} from "./user/user.module"
import {OrderModule} from "./order/order.module";
import {MovieModule} from "./movie/movie.module";


export const APP_IMPORTS = [
  NgbModule.forRoot(),
  ReactiveFormsModule,
  RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules }),
  UserModule,
  OrderModule,
  MovieModule
];

