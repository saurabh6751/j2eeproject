import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-editnnews',
  templateUrl: './editnnews.component.html',
  styleUrls: ['./editnnews.component.css']
})
export class EditnnewsComponent implements OnInit {

  constructor(public activeRoute:ActivatedRoute,
    public service:DataService,
    public router:Router) { }
    no:any;
    n:any;
    image:any;
  ngOnInit() {
    this.activeRoute.paramMap.subscribe((params)=>{
      this.no=params.get("no");

      this.service.getNewsById(this.no).subscribe((res)=>{

        console.log(res);
        this.n=res;
        
        console.log(this.n);

      })


    })

  }
  onSelectFile(event) {
    this.image = event.target.files[0];
  }
  
  update(){
    this.n.no=this.no;
     this.service.updateNews(this.n,this.image).subscribe((res)=>{
       console.log(res);
       this.router.navigate(['/admin/home/news']);
  
     })
  
   }
  
}
