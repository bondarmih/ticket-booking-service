import {Movie} from "./movie";
import {Hall} from "./hall";
/**
 * Created by bondarm on 02.01.17.
 */
export class Session {
    id: number;
    hall: Hall;
    timeStart: Date;
    movie: Movie;
    priceReg: number;
    priceVip: number;
    priceRegDiscount: number;
    priceVipDiscount: number;
    regSeatsAvailable: number;
    vipSeatsAvailable: number;
    discounts: string[];
}
