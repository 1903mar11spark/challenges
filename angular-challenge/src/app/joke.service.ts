import { Injectable } from '@angular/core';
import { HttpClientModule, HttpHeaders} from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
 
import { Joke } from './joke';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({providedIn: 'root'})
export class JokeService {
  constructor( private http:Http) { }

  getData(){
    this.http.get('https://official-joke-api.appspot.com/random_joke')
    .map((res:Response) => (res.text()
    ))
    .subscribe(data => {console.log(data)})
  }
}
