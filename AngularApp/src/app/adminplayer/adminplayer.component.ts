import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { rollInOnEnterAnimation } from "angular-animations";

@Component({
  selector: 'app-adminplayer',
  templateUrl: './adminplayer.component.html',
  styleUrls: ['./adminplayer.component.css'],
  animations: [
    rollInOnEnterAnimation()
  ]
})
export class AdminplayerComponent implements OnInit {

  constructor(private s:DataService) { }
  player:any;
  ngOnInit() {
  this.getData()
  }
  getData()
  {
    this.s.getPlayers().subscribe(r=>{
      console.log(r);
      this.player=r;
    })
  }
  delete(no){
    const res = confirm("Are you sure want to delete Player with ID : "+no);
    if(res==true){
      this.s.deletePlayerById(no).subscribe((res)=>{
        this.getData();
      })
    }
    
  }
}
