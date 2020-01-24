import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-addnewteam',
  templateUrl: './addnewteam.component.html',
  styleUrls: ['./addnewteam.component.css']
})
export class AddnewteamComponent implements OnInit {
  team:any;
  image:any;
  message:any;
  constructor(private s:DataService) { }

  ngOnInit() {
  }
  onSelectFile(event) {
    this.image = event.target.files[0];
  }
  onAdd(myForm)
  {
    console.log(myForm.form.value);
    this.team=myForm.form.value;
    console.log(this.team)
    console.log(this.image)

    this.s.addTeam(this.team,this.image).subscribe(r=>{
      console.log(r);
      this.message="team added successfully";
    })
  }
}
