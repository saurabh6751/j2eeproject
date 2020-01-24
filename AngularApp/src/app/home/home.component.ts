import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private s:DataService) { }

  ngOnInit() {
  }
  onAdd(myForm){
    console.log(myForm.form.value)
    this.s.seachPlayer(myForm.form.value).subscribe(r=>{
      console.log(r);
    })
  }
}
