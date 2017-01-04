/**
 * Created by bondarm on 02.01.17.
 */
import {Component, OnInit} from '@angular/core';
import {Movie} from "../movie/movie";
import {MovieService} from "../services/movie.service";



@Component({
    moduleId: 'module.id',
    selector: 'register-form',
    template: require('./register.component.html'),
    styles: [ require('./register.component.css')]
})

export class RegisterComponent {
}
