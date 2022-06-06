import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Int1 } from '../interfaces/int1';

@Injectable({
  providedIn: 'root'
})
export class Serv1Service {

  url:string="http://localhost:8080/lab1/Servlet2";
  constructor(private http:HttpClient) { }

  getSport():Observable<Int1[]>{
    return this.http.get<Int1[]>(this.url)
  }
}
