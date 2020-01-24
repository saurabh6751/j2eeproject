import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { slideInRightOnEnterAnimation } from 'angular-animations';


@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css'],
  animations:[
    slideInRightOnEnterAnimation()
    ]
})
export class NewsComponent implements OnInit {

  constructor(private s:DataService) { }
  news:any;
  ngOnInit() {
    this.s.getNews().subscribe(r=>{
      console.log(r);
      this.news = r;
      console.log(this.news);

    })
  }
}
