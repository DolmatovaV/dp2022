import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Int1 } from '../interfaces/int1';

@Injectable({
  providedIn: 'root'
})
export class Service1Service {
  
  list = new BehaviorSubject<Int1[]>([]);
url:string="http://localhost:8080/lab1/Servlet1"

constructor(private http:HttpClient) { }
getSport():Observable<Int1[]>{
  return this.http.get<Int1[]>(this.url);
}

postSport(sport:Int1):Observable<Int1[]>{
  return this.http.post<Int1[]>(this.url, sport);
}
putSport(sport:Int1):Observable<Int1[]>{
  return this.http.put<Int1[]>(this.url+"/"+sport.id, sport);
}
deleteSport(sport:Int1):Observable<Int1[]>{
  return this.http.delete<Int1[]>(this.url+"/"+sport.id);
}
setList(list:Int1[]){
  this.list.next(list);
  }

}
