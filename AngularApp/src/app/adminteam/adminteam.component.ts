import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { fadeInOnEnterAnimation } from "angular-animations";

@Component({
  selector: 'app-adminteam',
  templateUrl: './adminteam.component.html',
  styleUrls: ['./adminteam.component.css'],
  animations:[
    fadeInOnEnterAnimation()
 ]
})
export class AdminteamComponent implements OnInit {

  constructor(private s:DataService) { }
  team:any
  ngOnInit() {
    this.getData()
  }
  getData()
  {
    this.s.getTeams().subscribe(r=>{
          console.log(r);
          this.team = r;
        }
      )
  }
  delete(no){
    const res = confirm("Are you sure want to delete Team with ID : "+no);
    if(res==true){
      this.s.deleteTeams(no).subscribe((res)=>{
        this.getData();
      })
    }
    
  }
}
