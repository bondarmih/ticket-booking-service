import {Movie} from "./movie";
import {Injectable} from "@angular/core";
import {Http, Headers, Response, RequestOptions} from '@angular/http';
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

  public saveMovie(movie: Movie): Observable<string> {
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    return this.http.post(this.getMoviesUrl, movie, options)
      .map((response: Response) => {
        return response.status;
      })
      .catch(this.handleError);
  }

  public deleteMovie(id: number): Observable<string> {
    let url = `${this.getMoviesUrl}${id}`;
    return this.http.delete(url)
      .map((response: Response) => {
        return response.status;
      })
      .catch(this.handleError);
  }

  private handleError(error: Response | any) {
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }
}
