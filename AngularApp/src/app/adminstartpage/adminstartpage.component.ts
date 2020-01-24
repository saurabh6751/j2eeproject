import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { flipInXOnEnterAnimation } from "angular-animations";

@Component({
  selector: 'app-adminstartpage',
  templateUrl: './adminstartpage.component.html',
  styleUrls: ['./adminstartpage.component.css'],
  animations:[
    flipInXOnEnterAnimation()
  ]
})
export class AdminstartpageComponent implements OnInit {
  constructor(private s:DataService) { }
  noT:any;
  noN:any;
  noP:any;
  noTeam:any;
  noM:any;
  name:any;
  ngOnInit() {
    this.name = window.sessionStorage.getItem("name");
      console.log(this.name)
    this.s.getNoOfTournaments().subscribe(r=>{
      this.noT=r;
    })
    this.s.getNoNews().subscribe(r=>{
      this.noN=r;
    })
    this.s.getNoOfPlayers().subscribe(r=>{
      this.noP = r;
    })
    this.s.getNoOfTeams().subscribe(r=>{
      this.noTeam = r;
    })
    this.s.getNoOfMatch().subscribe(r=>{
      this.noM = r;
    })
  }
}
