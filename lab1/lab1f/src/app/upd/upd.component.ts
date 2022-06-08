import { Component, OnInit } from '@angular/core';
import { Int1 } from '../interfaces/int1';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-upd',
  templateUrl: './upd.component.html',
  styleUrls: ['./upd.component.scss']
})
export class UpdComponent implements OnInit {

  
  sportList:Int1[]=[];
  
  constructor(private service:Service1Service) { }


  ngOnInit(): void {
    this.getSport();
  }

  getSport():void{
    this.service.getSport().subscribe(
      (sport)=>{
        this.sportList=sport;
        this.service.setList(sport);
      }
    )
  }

  updSport(sport:Int1){
    this.service.putSport(sport).subscribe(
      ()=>{
        this.getSport();
      }
    )
  }

}
