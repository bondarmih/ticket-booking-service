import {Component, Input} from "@angular/core";
import {OnInit} from "@angular/core";
import {MovieService} from "../movie.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Movie} from "../movie";
import {Location} from '@angular/common';
import 'rxjs/add/operator/switchMap';

@Component({
    moduleId: 'module.id',
    selector: 'movie-list',
    template: require('./movie-details.component.html'),
    styles: [ require('./movie-details.component.css')]
})

export class MovieDetailsComponent implements OnInit{

    @Input()
    movie: Movie;

    private date: Date = new Date();

    constructor(
        private movieService: MovieService,
        private route: ActivatedRoute,
        private location: Location
    ) {}

    ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.movieService.getMovie(+params['id']))
            .subscribe(movie => this.movie = movie);
    }
}
