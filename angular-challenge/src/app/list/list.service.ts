import { Injectable } from '@angular/core'

import { HttpClient } from '@angular/common/http';



@Injectable()
export class ListService {

    constructor (private http: HttpClient) {}

    fetchWord(){
        return this.http.get("https://baconipsum.com/api/?type=meat-and-filler");
    }

}