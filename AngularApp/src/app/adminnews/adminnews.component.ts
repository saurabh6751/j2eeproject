import { Component, OnInit } from '@angular/core';
import { slideInRightOnEnterAnimation } from 'angular-animations';
import { DataService } from '../data.service';
@Component({
  selector: 'app-adminnews',
  templateUrl: './adminnews.component.html',
  styleUrls: ['./adminnews.component.css'],
  animations:[
    slideInRightOnEnterAnimation()
    ]
})
export class AdminnewsComponent implements OnInit {

  constructor(private s:DataService) { }
  news:any;
  ngOnInit() {
    this.getData();
  }
  getData()
  {
    this.s.getNews().subscribe(r=>{
      console.log(r);
      this.news = r;
      console.log(this.news);

    })
  }
  delete(no){
    const res = confirm("Are you sure want to delete news with ID : "+no);
    if(res==true){
      this.s.deleteNews(no).subscribe((res)=>{
        this.getData();
      })
    }
    
  }


}
