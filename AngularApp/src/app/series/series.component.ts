import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { bounceInDownOnEnterAnimation } from "angular-animations";

@Component({
  selector: 'app-series',
  templateUrl: './series.component.html',
  styleUrls: ['./series.component.css'],
  animations:[
    bounceInDownOnEnterAnimation()
  ]
})
export class SeriesComponent implements OnInit {

  constructor(private s:DataService) { }
  tournament:any;
  ngOnInit() {
      this.s.getTournaments().subscribe(r=>{
        console.log(r);
        this.tournament=r;
      })
    }

}
