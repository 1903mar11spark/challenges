import { Component, OnInit, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-add-hood',
  templateUrl: './add-hood.component.html',
  styleUrls: ['./add-hood.component.css']
})
export class AddHoodComponent implements OnInit {

  @Output() addHood: EventEmitter<any> = new EventEmitter();

  name: string;

  constructor() { }

  ngOnInit() {
  }

  onSubmit(){
    const hood ={
      name: this.name
    }
  
//needs to be emitted upwards
 this.addHood.emit(hood);

}
}