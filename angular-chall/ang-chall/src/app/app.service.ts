import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from './customer';
@Injectable({
  providedIn: 'root'
})
export class AppService {

apiURL: string = 'http://www.server.com/api/';
public firstPage: string = "";
public prevPage: string = "";
public nextPage: string = "";
public lastPage: string = "";

  constructor(private httpClient: HttpClient) {}HttpClient
}
