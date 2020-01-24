import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth-service.service';
import { DataService } from '../data.service';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit {
  name:any;
  constructor(private service:AuthService,private s:DataService) { }
  ngOnInit() {
      
  }

  signout()
  {
    this.service.Logout();
  }

}
