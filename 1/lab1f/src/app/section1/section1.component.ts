import { Component, OnInit } from '@angular/core';
import { Int1 } from '../interfaces/int1';
import { Serv1Service } from '../services/serv1.service';


@Component({
  selector: 'app-section1',
  templateUrl: './section1.component.html',
  styleUrls: ['./section1.component.scss']
})
export class Section1Component implements OnInit {

  sportList:Int1[]=[];
  constructor(private service:Serv1Service) { }

  getSport():void{
    this.service.getSport().subscribe(
      (sport)=>{
        this.sportList=sport;
      }
    )
  }

  ngOnInit(): void {
    this.getSport();
  }

}