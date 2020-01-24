import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { FormGroup,FormControl } from "@angular/forms";

@Component({
  selector: 'app-addnewmatch',
  templateUrl: './addnewmatch.component.html',
  styleUrls: ['./addnewmatch.component.css']
})
export class AddnewmatchComponent implements OnInit {

  constructor(private s:DataService) { }
  tour:any;
  message:any;
  team:any;
  ngOnInit() {
    this.s.getTournaments().subscribe(r=>{
        this.tour=r;
    })
  }
  onAdd(myForm)
  {
    console.log(myForm.form.value);
   this.s.addMatch(myForm.form.value).subscribe(r=>{
      console.log(r);
      this.message="match added successfully";
    });
  }
}
