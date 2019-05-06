import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  name: string= 'Neighborhoods of London';

  constructor(){
    console.log(123);
  }
  //  title = 'Wizards of Revature';
}
