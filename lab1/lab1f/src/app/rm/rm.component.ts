import { Component, OnInit, Input, Output } from '@angular/core';
import { Int1 } from '../interfaces/int1';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-rm',
  templateUrl: './rm.component.html',
  styleUrls: ['./rm.component.scss']
})
export class RmComponent implements OnInit {


  

  sportList:Int1[]=[];
  constructor(private service:Service1Service) { }



  getSport():void{
    this.service.getSport().subscribe(
      (sport)=>{
        this.sportList=sport;
        this.service.setList(sport);
      }
    )
  }
  


  ngOnInit(): void {
    this.getSport();
  }
  
  removeSport(sport:Int1){
    this.service.deleteSport(sport).subscribe(
      ()=>{
        this.getSport();
      }
    )
  }
  

}
