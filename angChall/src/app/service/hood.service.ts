import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import {Observable} from 'rxjs';
import { Hood } from 'src/app/models/hoods';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':'application/json'
  })
}

@Injectable({
  providedIn: 'root'
})

export class HoodService {

  constructor(private http:HttpClient) { }

  hoodUrl: string = 'https://data.police.uk/api/leicestershire/neighbourhoods';

  getHood():Observable<Hood[]>{
    return this.http.get<Hood[]>(`${this.hoodUrl}`);
  }

  deleteHood(hood:Hood):Observable<Hood>{
    //need id like with the put requests
    const url = `${this.hoodUrl}/${hood.id}`;
    return this.http.delete<Hood>(url,httpOptions);
  }
  
  //add todo
  addHood(hood:Hood):Observable<Hood> {
    return this.http.post<Hood>(this.hoodUrl, hood, httpOptions);
  }
}
