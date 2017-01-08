import {Movie} from "./movie";
import {Injectable} from "@angular/core";
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map'
import {Observable} from 'rxjs/Rx';

/**
 * Created by bondarm on 02.01.17.
 */


let MOVIES: Movie[] = [
    {
        id: 1,
        name: 'movie #1',
        description: 'description of movie#1',
        starting: new Date(2016, 4, 6),
        genre: 'comedy',
        duration: 120
    },
    {
        id: 2,
        name: 'movie #2',
        description: 'description of movie#2',
        starting: new Date(2016, 8, 11),
        genre: 'comedy',
        duration: 118
    },
    {
        id: 3,
        name: 'movie #3',
        description: 'description of movie#3',
        starting: new Date(2016, 10, 28),
        genre: 'comedy',
        duration: 105
    }
];

@Injectable()
export class MovieService {

    private getMoviesUrl: string = 'movies/';

    constructor(
        private http: Http
    ){}

    getMovies(): Observable<Movie[]> {
        return this.http.get(this.getMoviesUrl)
            .map((response: Response) => response.json() as Movie[])
            .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
    }

    getMovie(id: number): Observable<Movie> {
        let url = `${this.getMoviesUrl}${id}`;
        return this.http.get(url)
            .map((response: Response) => response.json() as Movie )
            .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
    }
}
