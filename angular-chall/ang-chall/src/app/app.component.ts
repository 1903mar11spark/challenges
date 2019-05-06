import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { Customer } from './customer';

interface Course {
  description: string;
  courseListIcon:string;
  iconUrl:string;
  longDescription:string;
  url:string;
}


@Component({
  selector: 'app-root',
  template: `
  <h1>
  {{ title }}
  </h1>
  <ul *ngIf="courses$ | async as courses else noData">
          <li *ngFor="let course of courses">
              {{course.description}}
          </li> 
      </ul>
      <ng-template #noData>No Data Available</ng-template>
  `,
  styleUrls: ['./app.component.css']
})


export class AppComponent  {
  title = 'Angular Code Challenge';
}
