import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { zoomInOnEnterAnimation } from "angular-animations";

@Component({
  selector: 'app-admintournament',
  templateUrl: './admintournament.component.html',
  styleUrls: ['./admintournament.component.css'],
  animations:[
    zoomInOnEnterAnimation()
  ]
})
export class AdmintournamentComponent implements OnInit {

  constructor(private s:DataService) { }
  tournament:any;
  ngOnInit() {
      this.getData()
    }
    getData()
    {
      this.s.getTournaments().subscribe(r=>{
        console.log(r);
        this.tournament=r;
      })
    }
    delete(no){
      const res = confirm("Are you sure want to delete Tournament with ID : "+no);
      if(res==true){
        this.s.deleteTournaments(no).subscribe((res)=>{
          this.getData();
        })
      }
      
    }

}