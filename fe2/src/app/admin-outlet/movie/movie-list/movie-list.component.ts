/**
 * Created by bondarm on 15.01.17.
 */
import { Component, OnInit } from '@angular/core';
import {Movie} from "../../../movie/movie";
import {Hall} from "../../../movie/hall";

@Component({
  moduleId: module.id,
  selector: 'movie-list',
  templateUrl: 'movie-list.component.html'
})
export class AdminMovieListComponent implements OnInit {

  movies: Movie[];
  selected: Hall;

  constructor() { }

  ngOnInit() { }

}
