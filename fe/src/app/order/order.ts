import {Session} from "../session/session";
import {User} from "../user/user";
/**
 * Created by bondarm on 07.01.17.
 */
export class Order {
    id: number;
    date: Date;
    user: User;
    session: Session;
    regTicketsCount: number;
    vipTicketsCount: number;
    price: number;
    discounts: string[];
    confirmed: boolean;

    constructor(
        session: Session,
        user: User
    ) {
        this.id = -1;
        this.date = new Date;
        this.user = user;
        this.session = session;
        this.regTicketsCount = 0;
        this.vipTicketsCount = 0;
        this.price = 0;
        this.discounts = [];
        this.confirmed = false;

        console.log('order' + JSON.stringify(this));
    }

}
