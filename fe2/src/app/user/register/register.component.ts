/**
 * Created by bondarm on 02.01.17.
 */
import {Component, OnInit} from '@angular/core';
import {UserService} from "../user.service";
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, FormBuilder, Validators,
   ValidatorFn, AbstractControl } from '@angular/forms';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map'


@Component({
    moduleId: 'module.id',
    selector: 'register-form',
    templateUrl: 'register.component.html',
    styleUrls: ['register.component.css']
})

export class RegisterComponent implements OnInit{

  user: any = {};
  loading = false;
  returnUrl: string = 'login';
  submitted: boolean = false;
  userForm: FormGroup;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private userService: UserService,
              private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.buildForm();
  }

  buildForm(): void {
    this.userForm = this.fb.group({
        'username': [this.user.name, [
          Validators.required,
          Validators.minLength(4),
          Validators.maxLength(24)
        ]],
        'password': [this.user.password, [
          Validators.required,
          Validators.minLength(4),
          Validators.maxLength(24)
        ]],
        'dateOfBirth': [this.user.dateOfBirth, [
          Validators.required,
        ]]
      }
    );

    this.userForm.valueChanges.subscribe(data => this.onValueChanged(data));

    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    if (!this.userForm) { return; }
    const form = this.userForm;
    console.log(JSON.stringify(form.value))
    for (const field in this.formErrors) {
      // clear previous error message (if any)
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
    'username': '',
    'password': '',
    'dateOfBirth': ''
  };


  validationMessages = {
    'username': {
      'required':      'Имя обязательно.',
      'minlength':     'Имя должно быть не короче 4 символов.',
      'maxlength':     'Имя должно быть не длиннее 24 символов.',
      'nameOccupied':  'Это имя занято.'
    },
    'password': {
      'required':      'Пароль обязателен.',
      'minlength':     'Пароль должен быть не короче 4 символов.',
      'maxlength':     'Пароль должен быть не длиннее 24 символов.',
    },
    'dateOfBirth': {
      'required':      'Дата рождения обязательна',
      'properDate':    'Дата рождения не может быть позже, чем сегодня'
    }};


  private nameExistValidate(control: AbstractControl): Observable<{[key: string]: any}>  {
    const name = control.value;
    if (name == null) {
      return Observable.of(null);
    }
    return this.userService.getUserByName(name)
      .map(user => {
        if (user) {
          console.log('name exist' + JSON.stringify(user));
          return {'nameOccupied': true}
        } else {
          return null;
        }
      });
  }



  private properDateValidator(): ValidatorFn {
    return (control: AbstractControl): {[key: string]: any} => {
      const date = control.value;
      console.log('datevalue' + control.value);
      return (date >= new Date ? {'properDate' : {}} : null);
    }
  }


  register(): void {
    this.submitted = true;
    this.user = this.userForm.value;
    this.loading = true;
    this.userService.addUser(
      this.user.username,
      this.user.password,
      this.user.dateOfBirth)
      .subscribe(
        data => {

            this.router.navigate([this.returnUrl]);

        },
        error => {
          this.loading = false;
          console.log(error);
        });

  }
}
