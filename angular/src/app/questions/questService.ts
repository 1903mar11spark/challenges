import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Quest} from '../Quest';

const heetOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json'
    })
}

@Injectable({
    providedIn: 'root'
})

export class QuestService{
    constructor (private http:HttpClient){}
    URL: string = "https://opentdb.com/api.php?amount=10&difficulty=easy&type=boolean";
  
    getQuests(): Observable<Quest[]>{
        return this.http.get<Quest[]>(`${this.URL}`);
    }
}