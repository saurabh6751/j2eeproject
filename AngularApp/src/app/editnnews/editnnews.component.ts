import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-editnnews',
  templateUrl: './editnnews.component.html',
  styleUrls: ['./editnnews.component.css']
})
export class EditnnewsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  news={
    id:1,
    date:"10-12-2019",
    category:"cricket stadiums",
    heading:"biggest stadium in world built in ahmedabad",
    descrption:"India has a mix color of sports like famous guli danda to the International cricket, though cricket is heartbeat of the nation but kockey is also very popular game in India along with football. Apart from the above few games, India is home for second largest football stadium in the world named as Salt Lake Stadium in Kolkata. Some of the multi purpose stadium has been constructed in India to boost the other Olympic sports. Here are list of biggest sports stadium in India capacity wise."
};

}
