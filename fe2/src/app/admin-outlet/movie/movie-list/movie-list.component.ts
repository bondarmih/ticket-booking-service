/**
 * Created by bondarm on 15.01.17.
 */
import { Component, OnInit } from '@angular/core';
import {Movie} from "../../../movie/movie";
import {Hall} from "../../../movie/hall";
import {MovieService} from "../../../movie/movie.service";

@Component({
  moduleId: module.id,
  selector: 'movie-list',
  templateUrl: 'movie-list.component.html'
})
export class AdminMovieListComponent implements OnInit {

  movies: Movie[];
  selected: Movie;

  constructor(
    private movieService: MovieService,
  ) { }

  ngOnInit() {
    this.getMovies();
  }

  getMovies() {
    this.movieService.getMovies()
      .subscribe(movies => this.movies = movies);
  }

  onSelect(movie: Movie) {
    this.selected = movie;
  }

  onDataChanged(event) {
    if(event) {
      this.selected = null;
    }
    this.getMovies();
  }


}
