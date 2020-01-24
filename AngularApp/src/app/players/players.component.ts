import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-players',
  templateUrl: './players.component.html',
  styleUrls: ['./players.component.css']
})
export class PlayersComponent implements OnInit {
  constructor(private s:DataService) { }
  player:any;
  ngOnInit() {
    this.s.getPlayers().subscribe(r=>{
      console.log(r);
      this.player=r;
    })
  }

}
