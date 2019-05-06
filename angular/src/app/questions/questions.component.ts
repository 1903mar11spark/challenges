import { Component, OnInit } from '@angular/core';
//import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";
import { Observable } from 'rxjs';
import * as _ from 'lodash';


interface Response{
  catagory: string;
  question: string;
  cAnswer: string;
  wAnswer: string[];
}
@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {
responses$: Observable<Response[]>;
  constructor( private http:HttpClient) { }

respUrl: string = 'https://opentdb.com/api.php?amount=10&difficulty=medium'
getResp():Observable<Response[]>{
return this.getResp.http.get<Response[]>(`${this.respUrl}`);
}
  ngOnInit() {
    this.responses$=this.http
      .get<Response[]>("/responses.json")
      .map(data=> _.values(data))
      .do(console.log);
  }

}
