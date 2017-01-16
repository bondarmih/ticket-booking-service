/**
 * Created by bondarm on 15.01.17.
 */
import { Input, Output, Component, OnInit, OnChanges, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators} from '@angular/forms';
import {Movie} from "../../../movie/movie";
import {MovieService} from "../../../movie/movie.service";

@Component({
  moduleId: module.id,
  selector: 'movie-details',
  templateUrl: 'movie-details.component.html'
})
export class AdminMovieDetailsComponent implements OnInit, OnChanges {

  @Input()
  movie: Movie;

  loading = false;
  submitted = false;
  movieForm: FormGroup;
  successMessage: string = '';
  errorMessage: string = '';

  @Output()
  dataChanged = new EventEmitter();

  constructor(
    private movieService: MovieService,
    private fb: FormBuilder
  ) { }

  ngOnInit() {
//    this.buildForm();
  }

  ngOnChanges() {
//    this.buildForm()
  }

  onDataChanged(reload: boolean) {
//    this.dataChanged.emit(reload);
  }


  private buildForm(): void {
    this.movieForm = this.fb.group(
      {
        'id': [
          {value: this.movie.id, disabled: true},
          []
        ],
        'name': [
          this.movie.name,
          [
            Validators.required
          ]
        ],
        'description': [
          this.movie.description,
          [
            Validators.required
          ]
        ],
        'starting': [
          this.movie.starting,
          [
            Validators.required
          ]
        ],
        'genre': [
          this.movie.genre,
          [
            Validators.required
          ]
        ],
        'duration': [
          this.movie.duration,
          [
            Validators.required
          ]
        ],
        'price': [
          this.movie.price,
          [
            Validators.required
          ]
        ]
      }
    );
    this.movieForm.valueChanges.subscribe(data => this.onValueChanged(data));
    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    if (!this.movieForm) { return; }
    const form = this.movieForm;
    for (const field in this.formErrors) {
      this.formErrors[field] = '';
      const control = form.get(field);
      if (control && control.dirty && !control.valid) {
        const messages = this.validationMessages[field];
        for (const key in control.errors) {
          if (messages[key]) {
            this.formErrors[field] += messages[key] + ' ';
          }
        }
      }
    }
  }

  formErrors = {
    'id': '',
    'name': '',
    'description': '',
    'starting': '',
    'genre': '',
    'duration': '',
    'price': ''
  };

  validationMessages ={
    'name': {
      'required':       'Это поле должно быть заполнено',
    },
    'description': {
      'required':       'Это поле должно быть заполнено',
    },
    'starting': {
      'required':       'Это поле должно быть заполнено',
    },
    'genre': {
      'required':       'Это поле должно быть заполнено',
    },
    'duration': {
      'required':       'Это поле должно быть заполнено',
    },
    'price': {
      'required':       'Это поле должно быть заполнено',
    }
  };

  onSubmit(): void {
    this.submitted = true;
    console.log(JSON.stringify(this.movieForm.value));
    this.movie = this.movieForm.value;
    let string = this.movieForm.value.starting;
    let numbers = string.match(/\d+/g);
    let date = new Date(numbers[0], numbers[1]-1, numbers[2]);
    this.movie.id = 0;

    this.movie.starting = date;
    console.log(JSON.stringify(this.movie));
    this.loading = true;
    this.movieService.saveMovie(this.movie)
      .subscribe(
        data => {
          this.loading = false;
          this.successMessage = "Данные обновлены";
          this.onDataChanged(false);
        },
        error => {
          this.loading = false;
          console.log(error);
          this.errorMessage = "Ошибка отправки данных";
        }

      )
  }

  onAdd(): void {
    this.movie = new Movie;
    this.buildForm();
  }

  onDelete(): void {
    this.submitted = true;
    this.movie = this.movieForm.value;
    this.loading = true;
    this.movieService.deleteMovie(this.movie.id)
      .subscribe(
        data => {
          this.loading = false;
          this.onDataChanged(true);
        },
        error => {
          this.loading = false;
          console.log(error);
          this.errorMessage = "Ошибка отправки данных";
        }

      )
  }
}
