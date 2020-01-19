import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admintournament',
  templateUrl: './admintournament.component.html',
  styleUrls: ['./admintournament.component.css']
})
export class AdmintournamentComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  tournament=[{
    id:1,
    name:"big bash",
    organizer:"aussies",
    owner:"mahesh",
    startdate:"10-10-2019",
    enddate:"20-11-2019"
  },{
    id:2,
    name:"big bash",
    organizer:"aussies",
    owner:"mahesh",
    startdate:"10-10-2019",
    enddate:"20-11-2019"
  },{
    id:3,
    name:"big bash",
    organizer:"aussies",
    owner:"mahesh",
    startdate:"10-10-2019",
    enddate:"20-11-2019"
  },{
    id:4,
    name:"big bash",
    organizer:"aussies",
    owner:"mahesh",
    startdate:"10-10-2019",
    enddate:"20-11-2019"
  },{
    id:5,
    name:"big bash",
    organizer:"aussies",
    owner:"mahesh",
    startdate:"10-10-2019",
    enddate:"20-11-2019"
  },{
    id:6,
    name:"big bash",
    organizer:"aussies",
    owner:"mahesh",
    startdate:"10-10-2019",
    enddate:"20-11-2019"
  }]
}
