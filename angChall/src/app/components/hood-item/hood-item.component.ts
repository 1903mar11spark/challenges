import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';

import { Hood } from 'src/app/models/hoods';

import { HoodService } from 'src/app/service/hood.service';

@Component({
  selector: 'app-hood-item',
  templateUrl: './hood-item.component.html',
  styleUrls: ['./hood-item.component.css']
})
export class HoodItemComponent implements OnInit {

  @Input() hood: Hood;
  @Output() deleteHood;
  EventEmitter<Hood> = new EventEmitter();
  constructor(private hoodService:HoodService) { }

  ngOnInit() {
  }

  setClasses(){
    let classes = {
      hood: true,
      'is-complete': this.hood.completed
    }
    return classes;
  }

  

  onDelete(hood){
    console.log('delete');
    //emit upwards
    this.delete.emit(hood);
  }

}
