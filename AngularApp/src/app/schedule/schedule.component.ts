import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {
  constructor(private s:DataService) { }
  team:any;
  ngOnInit() {
    this.s.getMatch().subscribe(r=>{
      console.log(r);
      this.team=r;
    })
  }
}
