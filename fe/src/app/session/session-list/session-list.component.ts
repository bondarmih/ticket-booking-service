import {Component, Input} from "@angular/core";
import {Session} from "../session";



@Component({
    moduleId: 'module.id',
    selector: 'session-list',
    template: require('./session-list.component.html'),
    styles: [ require('./session-list.component.css')]
})

export class SessionListComponent {
    @Input()
    sessions: Session[];
    private today: Date;
    private tomorrow: Date;
    private afterTomorrow: Date;
    constructor () {
        this.today = new Date;
        this.tomorrow = new Date();
        this.tomorrow.setHours(0,0,0,0);
        this.tomorrow.setDate(this.tomorrow.getDate() + 1);
        this.afterTomorrow = new Date();
        this.afterTomorrow.setHours(0,0,0,0);
        this.afterTomorrow.setDate(this.afterTomorrow.getDate() + 2);
    }
}
