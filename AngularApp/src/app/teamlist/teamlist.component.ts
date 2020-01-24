import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-teamlist',
  templateUrl: './teamlist.component.html',
  styleUrls: ['./teamlist.component.css']
})
export class TeamlistComponent implements OnInit {

 
  constructor(private s:DataService,private route:ActivatedRoute) { }
  n:any;
  player:any;
  p=[];
  ngOnInit() {
    this.route.paramMap.subscribe((result)=>{
      let No= result.get("No");
    this.s.getTeamById(No).subscribe(r=>{
      this.n = r;
    })
  })
  this.route.paramMap.subscribe((result)=>{
    let No= result.get("No");
    this.s.getPlayers().subscribe(r=>{
      this.player = r;
      console.log(this.player[0].id)
      for (const id in this.player) {
        if (this.player.hasOwnProperty(id)) {
          console.log(No);
          const element = this.player[id];
          if(element.teamId.id==No)
            this.p.push(element);
        }
      }
      console.log(this.p)
    })
  })
  }
}
