import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-addnews',
  templateUrl: './addnews.component.html',
  styleUrls: ['./addnews.component.css']
})
export class AddnewsComponent implements OnInit {
  image:any;
  news:any;
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
    this.news=myForm.form.value;
    console.log(this.news)
    console.log(this.image)

    this.s.addNews(this.news,this.image).subscribe(r=>{
      console.log(r);
      this.message="news added successfully";
    })
  }
}
