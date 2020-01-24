import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { fadeInOnEnterAnimation } from "angular-animations";

@Component({
  selector: 'app-adminmatch',
  templateUrl: './adminmatch.component.html',
  styleUrls: ['./adminmatch.component.css'],
  animations:[
    fadeInOnEnterAnimation()
  ]
})
export class AdminmatchComponent implements OnInit {

  constructor(private s:DataService) { }
  team:any;
  ngOnInit() {
   this.getData()
  }
  getData()
  {
    this.s.getMatch().subscribe(r=>{
      console.log(r);
      this.team=r;
    })
  }
  delete(no){
    const res = confirm("Are you sure want to delete Match with ID : "+no);
    if(res==true){
      this.s.deleteMatchById(no).subscribe((res)=>{
        this.getData();
      })
    }
    
  }
}