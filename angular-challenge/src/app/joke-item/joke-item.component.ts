import { Component, OnInit, Input} from '@angular/core';

import { Joke } from '../joke';
import { JokeService } from '../joke.service';


@Component({
  selector: 'app-joke-item',
  templateUrl: './joke-item.component.html',
  styleUrls: ['./joke-item.component.css']
})
export class JokeItemComponent implements OnInit {
  @Input() joke: Joke;
  
  constructor(private jokeService:JokeService) { }

  ngOnInit() {
  }

  //set dynamic classes
  setClasses(){
    let classes = {
      joke: true,
      'is-completed': this.joke.completed
    }
    return classes;
  }

  onToggle(joke){
    console.log('toggle');
    //toggle in UI
    joke.completed = !joke.completed;
    //toggle on server
    this.jokeService.toggleCompleted(joke).subscribe(joke => console.log(joke));
  }


}