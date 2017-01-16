/**
 * Created by bondarm on 15.01.17.
 */
import { Input, Output, Component, OnInit, OnChanges, EventEmitter } from '@angular/core';
import {Hall} from "../../../movie/hall";
import {HallService} from "../../service/hall.service";
import { FormGroup, FormBuilder, Validators} from '@angular/forms';

@Component({
  moduleId: module.id,
  selector: 'hall-details',
  templateUrl: 'hall-details.component.html'
})
export class AdminHallDetailsComponent implements OnInit, OnChanges {

  @Input()
  hall: Hall;

  loading = false;
  submitted = false;
  hallForm: FormGroup;
  successMessage: string = '';
  errorMessage: string = '';

  @Output()
  dataChanged = new EventEmitter();

  constructor(
    private hallService: HallService,
    private fb: FormBuilder,
  ) { }

  ngOnInit() {
    this.buildForm();
  }

  ngOnChanges() {
    this.buildForm()
  }

  onDataChanged(reload: boolean) {
    this.dataChanged.emit(reload);
  }


  private buildForm(): void {
    this.hallForm = this.fb.group(
      {
        'id':
          [
            { value: this.hall.id, disabled: true},
            [
            ]
          ],
        'name':
          [
            this.hall.name,
            [
              Validators.required
            ]
          ],
        'regularSeats':
          [
            this.hall.regularSeats,
            [
              Validators.required
            ]
          ],
        'vipSeats':
          [
            this.hall.vipSeats,
            [
              Validators.required
            ]
          ],
        'regMult':
          [
            this.hall.regMult,
            [
              Validators.required
            ]
          ],
        'vipMult':
          [
            this.hall.vipMult,
            [
              Validators.required
            ]
          ]
      }
    );

    this.hallForm.valueChanges.subscribe(data => this.onValueChanged(data));
    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    if (!this.hallForm) { return; }
    const form = this.hallForm;
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
    'name': '',
    'regularSeats': '',
    'vipSeats': '',
    'regMult': '',
    'vipMult': ''
  };

  validationMessages ={
    'name': {
      'required':       'Это поле должно быть заполнено',
    },
    'regularSeats': {
      'required':       'Это поле должно быть заполнено',
    },
    'vipSeats': {
      'required':       'Это поле должно быть заполнено',
    },
    'regMult': {
      'required':       'Это поле должно быть заполнено',
    },
    'vipMult': {
      'required':       'Это поле должно быть заполнено',
    }
  };

  onSubmit(): void {
    this.submitted = true;
    this.hall = this.hallForm.value;
    this.loading = true;
    this.hallService.saveHall(this.hall)
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
    this.hall = new Hall;
    this.buildForm();
  }

  onDelete(): void {
    this.submitted = true;
    this.hall = this.hallForm.value;
    this.loading = true;
    this.hallService.deleteHall(this.hall.id)
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
