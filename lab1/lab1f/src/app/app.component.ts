import { Component } from '@angular/core';
import { Int1 } from './interfaces/int1';
import { Service1Service } from './services/service1.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'lab1f';
  sportList:Int1[]=[];
}
