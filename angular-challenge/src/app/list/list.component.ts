import { ListService } from './list.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  public list = {};
  constructor(private _listService: ListService) { }

  ngOnInit() {
    this._listService.fetchWord()
    .subscribe(data => this.list = data);
  }

}
