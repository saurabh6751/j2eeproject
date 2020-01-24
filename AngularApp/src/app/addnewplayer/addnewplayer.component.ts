import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-addnewplayer',
  templateUrl: './addnewplayer.component.html',
  styleUrls: ['./addnewplayer.component.css']
})
export class AddnewplayerComponent implements OnInit {

  constructor(private s:DataService) { }
  team:any;
  image:any;
  message:any;
  player:any;
  ngOnInit() {
      this.s.getTeams().subscribe(r=>{
        console.log(r);
        this.team = r;
      })
  }
  onSelectFile(event) {
    this.image = event.target.files[0];
}
  onAdd(myForm)
  { console.log(myForm.form.value);
    this.player=myForm.form.value;
    console.log(this.player)
    console.log(this.image)

    this.s.addPlayer(this.player,this.image).subscribe(r=>{
      console.log(r);
      this.message="player added successfully";
  })
  }
}
