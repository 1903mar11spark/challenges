import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';

import { Observable, of } from 'rxjs';

import { Joke } from './joke';
import { MessageService } from './message.service';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({providedIn: 'root'})
export class JokeService {

  constructor( private http: HttpClient,
    private messageService: MessageService) { }

    jokeUrl: string = 'https://official-joke-api.appspot.com/random_ten';
  getJokes(): Observable<Joke[]>{
    return this.http.get<Joke[]>(`${this.jokeUrl}`);
  }

  toggleCompleted(joke:Joke):Observable<any> {
    const url = `${this.jokeUrl}/${joke.id}`;
    return this.http.put(url, joke, httpOptions);
  }
}
