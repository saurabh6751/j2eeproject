import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {

  constructor(private s:DataService) { }
  team:any;
  player:any;
  p=[];
  ngOnInit() {
    this.s.getTeams().subscribe(r=>{
      this.team = r;
    })
    this.s.getPlayers().subscribe(r=>{
      this.player = r;
      console.log(this.player[0].id)
      for (const id in this.player) {
        if (this.player.hasOwnProperty(id)) {
          const element = this.player[id];
          if(element.teamId.id==1)
            this.p.push(element);
        }
      }
      console.log(this.p)
    })
  }
}
