/**
 * Created by bondarm on 02.01.17.
 */

import {Pipe, PipeTransform} from "@angular/core";
import {Session} from "../session/session";
@Pipe({
    name: 'byDay'
})
export class ByDaySessions implements PipeTransform{
    transform(value: Session[], date: Date): Session[] {
        return value.filter(session => {
            return (session.timeStart.toDateString() == date.toDateString() &&
            session.timeStart.getTime() > date.getTime())
            }
        )
    }
}
