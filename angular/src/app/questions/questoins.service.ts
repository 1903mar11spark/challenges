import { Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class QuestionService{
    constructor (private http: HttpClient){}

   
    getQs(){
        return this.http.get("https://opentdb.com/api.php?amount=10&difficulty=easy&type=boolean");
    }

}

