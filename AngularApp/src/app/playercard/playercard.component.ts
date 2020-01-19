import { Component, OnInit } from '@angular/core';
import { fadeInOnEnterAnimation } from "angular-animations";

@Component({
  selector: 'app-playercard',
  templateUrl: './playercard.component.html',
  styleUrls: ['./playercard.component.css'],
  animations:[
    fadeInOnEnterAnimation()
  ]
})
export class PlayercardComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
