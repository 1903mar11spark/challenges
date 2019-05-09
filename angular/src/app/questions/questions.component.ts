import { Component, OnInit } from '@angular/core';
import { QuestionService} from './questoins.service'
import { Quest } from '../Quest';
import { QuestService } from './questService';



@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit{
  
// public quests= {};

//   constructor(private _qService: QuestionService){}

//   ngOnInit(){
//     this._qService.getQs().subscribe(data=> this.quests = data);
//   }

public quests={};

constructor(private questService: QuestService){}

ngOnInit(){}
getQs(){  
this.questService.getQuests().subscribe(quests =>{
    this.quests = quests
  });
}
public display= false;

public showA(): void{
  this.display = !this.display;
}

}