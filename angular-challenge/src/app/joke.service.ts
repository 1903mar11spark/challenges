import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { Joke } from './joke';
import { MessageService } from './message.service';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({providedIn: 'root'})
export class JokeService {

  private jokeUrl = 'https://official-joke-api.appspot.com/random_joke';

  constructor( private http: HttpClient,
    private messageService: MessageService) { }

  getJokes(): Observable<Joke[]>{
    return this.http.get<Joke[]>(this.jokeUrl)
    .pipe(
      tap(_ => this.log('fetched joke')),
    catchError(this.handleError<Joke[]>('getJokes', [])));
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error); // log to console instead
      this.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }

  private log(message: string){
    this.messageService.add(`JokeService: ${message}`);
  }
}
