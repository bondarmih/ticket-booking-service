/**
 * Created by bondarm on 02.01.17.
 */

import {Pipe, PipeTransform} from "@angular/core";
import {Session} from "./session";
@Pipe({
    name: 'afterDay'
})
export class AfterDaySessions implements PipeTransform{
    transform(value: Session[], date: Date): Session[] {
        return value.filter(session => {
            return (session.timeStart.getTime() > date.getTime())
            }
        )
    }
}
