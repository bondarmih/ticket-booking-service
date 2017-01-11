/**
 * Created by bondarm on 08.01.17.
 */
import {Pipe, PipeTransform} from "@angular/core";
import {Session} from "./session";
@Pipe({
    name: 'orderByDate'
})
export class OrderBySessions implements PipeTransform{
    transform(value: Session[]): Session[] {
        return value.sort((a: Session, b: Session) => {
            if (a.timeStart > b.timeStart) {
                return 1;
            } else
            if (a.timeStart < b.timeStart) {
                return -1;
            } else {
                return 0;
            }

        });
    }

}

