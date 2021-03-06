import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-playerinfo',
  templateUrl: './playerinfo.component.html',
  styleUrls: ['./playerinfo.component.css']
})
export class PlayerinfoComponent implements OnInit {

  constructor(private s:DataService,private route:ActivatedRoute) { }
  n:any;
  ngOnInit() {
    this.route.paramMap.subscribe((result)=>{
      let No= result.get("No");
      console.log(No);
    this.s.getPlayerById(No).subscribe(r=>{
      console.log(r);
      this.n=r;
      })
    })
  }
}
