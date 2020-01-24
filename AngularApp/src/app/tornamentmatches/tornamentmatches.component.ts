import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-tornamentmatches',
  templateUrl: './tornamentmatches.component.html',
  styleUrls: ['./tornamentmatches.component.css']
})
export class TornamentmatchesComponent implements OnInit {
  constructor(private s:DataService,private route:ActivatedRoute) { }
  n:any;
  matches:any;
  m=[];
  ngOnInit() {
    this.route.paramMap.subscribe((result)=>{
      let No= result.get("No");
      console.log(No);
    this.s.getTournamentById(No).subscribe(r=>{
      console.log(r);
      this.n=r;
      })
    })
    this.route.paramMap.subscribe((result)=>{
      let No= result.get("No");
      this.s.getMatch().subscribe(r=>{
        this.matches = r;
        console.log(this.matches)
        for (const id in this.matches) {
          if (this.matches.hasOwnProperty(id)) {
            console.log(No);
            const element = this.matches[id];
            if(element.tournamentId.id==No)
              this.m.push(element);
          }
        }
        console.log(this.m)
      })
    })
  }
}
