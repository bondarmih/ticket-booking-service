import {Movie} from "../movie/movie";
import {Injectable} from "@angular/core";
/**
 * Created by bondarm on 02.01.17.
 */


let MOVIES: Movie[] = [
    {
        id: 1,
        name: 'movie #1',
        description: 'description of movie#1',
        starting: new Date(2016, 4, 6),
        sessions: [
            {
                id: 1,
                hall: 'Зал №2',
                timeStart: new Date(2017, 0, 4, 10, 0, 0),
                regSeatsAvailable: 20,
                vipSeatsAvailable: 10,
                priceReg: 300,
                priceVip: 600,
                priceRegDiscount: 0,
                priceVipDiscount: 0
            },
            {
                id: 2,
                hall: 'Зал №4',
                timeStart: new Date(2017, 0, 4, 12, 0, 0),
                regSeatsAvailable: 36,
                vipSeatsAvailable: 8,
                priceReg: 350,
                priceVip: 700,
                priceRegDiscount: 0,
                priceVipDiscount: 0
            },
            {
                id: 3,
                hall: 'Зал №5',
                timeStart: new Date(2017, 0, 5, 10, 0, 0),
                regSeatsAvailable: 30,
                vipSeatsAvailable: 12,
                priceReg: 300,
                priceVip: 600,
                priceRegDiscount: 0,
                priceVipDiscount: 0
            },
            {
                id: 4,
                hall: 'Зал №2',
                timeStart: new Date(2017, 0, 7, 12, 0, 0),
                regSeatsAvailable: 36,
                vipSeatsAvailable: 8,
                priceReg: 350,
                priceVip: 700,
                priceRegDiscount: 0,
                priceVipDiscount: 0
            }
        ],
        genre: 'comedy',
        duration: 120
    },
    {
        id: 2,
        name: 'movie #2',
        description: 'description of movie#2',
        starting: new Date(2016, 8, 11),
        sessions: [
            {
                id: 5,
                hall: 'Зал №3',
                timeStart: new Date(2017, 0, 3, 12, 0, 0),
                regSeatsAvailable: 12,
                vipSeatsAvailable: 3,
                priceReg: 350,
                priceVip: 700,
                priceRegDiscount: 0,
                priceVipDiscount: 0
            },
            {
                id: 6,
                hall: 'Зал №2',
                timeStart: new Date(2017, 0, 4, 18, 0, 0),
                regSeatsAvailable: 39,
                vipSeatsAvailable: 10,
                priceReg: 400,
                priceVip: 800,
                priceRegDiscount: 0,
                priceVipDiscount: 0
            }
        ],
        genre: 'comedy',
        duration: 118
    },
    {
        id: 3,
        name: 'movie #3',
        description: 'description of movie#3',
        starting: new Date(2016, 10, 28),
        sessions: [],
        genre: 'comedy',
        duration: 105
    }
];

@Injectable()
export class MovieService {

    getMovies(): Promise<Movie[]> {
        return Promise.resolve(MOVIES);
    }

    getMovie(id: number): Promise<Movie> {
        return this.getMovies()
            .then(movies => movies.find(movie => movie.id === id));
    }
}
