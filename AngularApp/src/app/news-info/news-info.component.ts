import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-news-info',
  templateUrl: './news-info.component.html',
  styleUrls: ['./news-info.component.css']
})
export class NewsInfoComponent implements OnInit {

  constructor(private s:DataService,private route:ActivatedRoute) { }
  n:any;
  ngOnInit() {
    this.route.paramMap.subscribe((result)=>{
      let No= result.get("No");
      console.log(No);
    this.s.getNewsById(No).subscribe(r=>{
      console.log(r);
      this.n=r;
      })
    })
  }
}
