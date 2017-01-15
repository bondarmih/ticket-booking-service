/**
 * Created by bondarm on 15.01.17.
 */
import { Component, OnInit } from '@angular/core';
import {Hall} from "../../../movie/hall";
import {HallService} from "../../service/hall.service";

@Component({
  moduleId: module.id,
  selector: 'hall-list',
  templateUrl: 'hall-list.component.html'
})
export class AdminHallListComponent implements OnInit {

  halls: Hall[];
  selected: Hall;


  constructor(
    private hallService: HallService,
  ) { }

  ngOnInit() {
    this.getHalls();
  }

  getHalls() {
    this.hallService.getHalls()
      .subscribe(halls => this.halls = halls);
  }

  onSelect(hall: Hall): void {
    this.selected = hall;
  }

  onDataChanged(event) {
    if(event) {
      this.selected = null;
    }
    this.getHalls();

  }
}
