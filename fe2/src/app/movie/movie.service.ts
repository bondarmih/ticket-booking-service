import {Movie} from "./movie";
import {Injectable} from "@angular/core";
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map'
import {Observable} from 'rxjs/Rx';

/**
 * Created by bondarm on 02.01.17.
 */



@Injectable()
export class MovieService {

    private getMoviesUrl: string = 'api/movies/';

    constructor(
        private http: Http
    ){}

    getMovies(): Observable<Movie[]> {
        return this.http.get(this.getMoviesUrl)
            .map((response: Response) => {
              let data = response.json() || [];
              data.forEach(movie => movie.starting = new Date(movie.starting));
              return data as Movie[];
            })
            .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
    }

    getMovie(id: number): Observable<Movie> {
        let url = `${this.getMoviesUrl}${id}`;
        return this.http.get(url)
            .map((response: Response) => response.json() as Movie )
            .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
    }
}
