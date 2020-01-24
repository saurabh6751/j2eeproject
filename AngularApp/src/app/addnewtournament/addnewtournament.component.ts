import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addnewtournament',
  templateUrl: './addnewtournament.component.html',
  styleUrls: ['./addnewtournament.component.css']
})
export class AddnewtournamentComponent implements OnInit {
  tournament:any;
  message:any;
  image:any;
  constructor(public s:DataService,public router:Router) { }
  onSelectFile(event) {
    this.image = event.target.files[0];
}

    ngOnInit() {
   
  }
  onAdd(myForm)
  {
    console.log(myForm.form.value);
    this.tournament=myForm.form.value;
    console.log(this.tournament)
    console.log(this.image)

    this.s.addTour(this.tournament,this.image).subscribe(r=>{
      console.log(r);
      this.message="tournament added successfully";
    })
  }
}

