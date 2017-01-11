import {Component, Input} from "@angular/core";
import {Session} from "../session";



@Component({
    moduleId: 'module.id',
    selector: 'session-details',
    templateUrl: 'session-details.component.html',
    styleUrls: [ 'session-details.component.css']
})

export class SessionDetailsComponent{
    @Input()
    session: Session;

    @Input()
    withDate: boolean = false;


}
