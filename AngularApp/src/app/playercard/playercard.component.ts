import { Component, OnInit } from '@angular/core';
import { fadeInOnEnterAnimation } from "angular-animations";
import { DataService } from '../data.service';
import { ArrayType } from '@angular/compiler';

@Component({
  selector: 'app-playercard',
  templateUrl: './playercard.component.html',
  styleUrls: ['./playercard.component.css'],
  animations:[
    fadeInOnEnterAnimation()
  ]
})
export class PlayercardComponent implements OnInit {

  constructor(private s:DataService) { }
  player:any;
  message:any;
  ngOnInit() {
  }
  onAdd(myForm){
    console.log(myForm.form.value)
    this.s.seachPlayer(myForm.form.value).subscribe(r=>{
      console.log(r);
      this.player = r;
      if(this.player==null)
        {
          this.message = "Found 0 matching results";
        }
        this.message = "Found "+this.player.length+" matching results";
      
    })
  }
}
