import {Movie} from "../movie/movie";
/**
 * Created by bondarm on 02.01.17.
 */
export class Session {
    id: number;
    hall: string;
    timeStart: Date;
    movie: Movie;
    priceReg: number;
    priceVip: number;
    priceRegDiscount: number;
    priceVipDiscount: number;
    regSeatsAvailable: number;
    vipSeatsAvailable: number;
}
