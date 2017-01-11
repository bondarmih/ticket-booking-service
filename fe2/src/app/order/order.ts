import {Session} from "../movie/session";
import {User} from "../user/user";
/**
 * Created by bondarm on 07.01.17.
 */
export class Order {
    id: number;
    date: Date;
    user: User;
    session: Session;
    ticketsCount: number;
    vip: boolean;
    price: number;
    discounts: string[];
    confirmed: boolean;

}
