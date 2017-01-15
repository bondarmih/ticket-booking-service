/**
 * Created by bondarm on 02.01.17.
 */
import {Component, OnInit} from '@angular/core';
import {Movie} from "../movie";
import {MovieService} from "../movie.service";
import {ActivatedRoute, Params} from '@angular/router';
import 'rxjs/add/operator/switchMap';



@Component({
  moduleId: 'module.id',
  selector: 'movie-list',
  templateUrl: 'movie-list.component.html',
  styleUrls: [ 'movie-list.component.css']
})

export class MovieListComponent implements OnInit{
  private  movies: Movie[];
  tag: string = '';
  constructor(
    private movieService: MovieService,
    private route: ActivatedRoute
  ) {}

  getMovies(): void {
    this.movieService.getMovies()
      .subscribe(movies => this.movies = movies);
  }

  ngOnInit() {
    this.route.params
      .map((params: Params) => params['tag'])
      .subscribe(data => {
        this.tag = data;
        this.getMovies();
      })
  }
}
