/**
 * Created by bondarm on 02.01.17.
 */
import {Component, OnInit} from '@angular/core';
import {Movie} from "../movie";
import {MovieService} from "../../services/movie.service";



@Component({
    moduleId: 'module.id',
    selector: 'movie-list',
    template: require('./movie-list.component.html'),
    styles: [ require('./movie-list.component.css')]
})

export class MovieListComponent implements OnInit{
    movies: Movie[];

    constructor(
        private movieService: MovieService
    ) {}

    getMovies(): void {
        this.movieService.getMovies()
            .then(movies => this.movies = movies);
    }

    ngOnInit() {
        this.getMovies();
    }
}
