import { Component, OnInit } from '@angular/core';
import { Hood } from 'src/app/models/hoods';
import { HoodService } from 'src/app/service/hood.service';

@Component({
  selector: 'app-hood',
  templateUrl: './hood.component.html',
  styleUrls: ['./hood.component.css']
})
export class HoodComponent implements OnInit {
  hoods:Hood[];

  constructor(private hoodService:HoodService) { }

  ngOnInit() {
    this.hoodService.getHood().subscribe(hoods => {
      this.hoods = hoods
    });
  }


  deleteHood(hood:Hood){
    console.log('delete me');

    //removes from UI
    //using filter -- like for each or maps
    this.hoods= this.hoods.filter(t => t.id !== hood.id);

    //Removes from server
    this.hoodService.deleteHood(hood).subscribe(); //gives us an observable--just deleting not returning anything--can put the one above into the subscribe if you wanted to 
  }

  addHood(hood:Hood){
    this.hoodService.addHood(hood).subscribe(hood => {this.hoods.push(hood);
    });
  }

}
