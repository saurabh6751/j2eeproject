import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth-service.service';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit {

  constructor(private service:AuthService) { }

  ngOnInit() {
  }

  signout()
  {
    this.service.Logout();
  }

}
