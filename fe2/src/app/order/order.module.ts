import {NgModule} from '@angular/core'
import {OrderService} from "./order.service";
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule, Routes} from '@angular/router'
import {FormsModule} from '@angular/forms';
import {OrderComponent} from "./order.component";
import {CommonModule} from "@angular/common";
/**
 * Created by bondarm on 07.01.17.
 */

let orderRoutes: Routes = [
    {
        path: 'orders/withSession/:sessionId',
        component: OrderComponent
    }
];

@NgModule({
    declarations: [
        OrderComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        RouterModule.forChild(orderRoutes),
      CommonModule
    ],
    providers: [
        OrderService
    ],
    exports: [
        RouterModule
    ]
})

export class OrderModule{

}
