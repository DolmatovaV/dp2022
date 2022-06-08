import { Component, OnInit, Input, Output } from '@angular/core';
import { Int1 } from '../interfaces/int1';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.scss']
})
export class AddComponent implements OnInit {

  sportList:Int1[]=[];
  
  constructor(private service:Service1Service) { }


  ngOnInit(): void {
    
  }

  getSport():void{
    this.service.getSport().subscribe(
      (sport)=>{
        this.sportList=sport;
        this.service.setList(sport);
      }
    )
  }

  addSport(sport:Int1){
    this.service.postSport(sport).subscribe(
      ()=>{
        this.getSport();
      }
    )
  }

}
