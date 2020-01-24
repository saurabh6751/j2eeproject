import { Injectable } from '@angular/core';
import {  } from "@angular/animations";
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http:HttpClient) { }

  baseurl = "http://localhost:8080/Allcricket/";

  select()
  {
    return this.http.get(this.baseurl+"admin")
  }
  validate(adminObj)
  {
    return this.http.post(this.baseurl+"admin",adminObj);
  }
  addTour(form,logo)
  {
    console.log(form)
    console.log(logo)


    const formData = new FormData();
    formData.append("name",form.name);
    formData.append("organizer",form.organizer);
    formData.append("owner",form.owner);
    formData.append("startDate",form.startDate);
    formData.append("endDate",form.endDate);
    formData.append("logo",logo);

    console.log(formData.get("logo"))

    return this.http.post(this.baseurl+'tournament',formData);
  }

  addTeam(form,logo)
  {
    const formData = new FormData();
    formData.append("logo",logo);
    formData.append("name",form.name);
    formData.append("location",form.location);
    formData.append("owner",form.owner);
    formData.append("coach",form.coach);
    return this.http.post(this.baseurl+'teams',formData);
  }

  addPlayer(form,logo)
  {
    const formData = new FormData();
    formData.append("logo",logo);
    formData.append("name",form.name);
    formData.append("age",form.age);
    formData.append("contact",form.contact);
    formData.append("dob",form.dob);
    formData.append("role",form.role);
    formData.append("teamId",form.teamId);
    return this.http.post(this.baseurl+'player',formData);
  }
  seachPlayer(form)
  {
    console.log(form.name);
    return this.http.get(this.baseurl+'player/search/'+form.name);
  }
  addMatch(form)
  {
    console.log(form);
    const formData = new FormData();
    formData.append("umpire",form.umpire);
    formData.append("age",form.age);
    formData.append("tournamentId",form.tournamentId);
    formData.append("location",form.location);
    formData.append("date",form.date);
    formData.append("homeTeamId",form.homeTeamId);
    formData.append("awayTeamId",form.awayTeamId);
    console.log(formData.get("tournamentId"))
    return this.http.post(this.baseurl+'match',formData);
  }
  addNews(form,image)
  {
    const formData = new FormData();
    formData.append("image",image);
    formData.append("date",form.date);
    formData.append("category",form.category);
    formData.append("heading",form.heading);
    formData.append("description",form.description);
   
    return this.http.post(this.baseurl+'news',formData);
  }
  updateNews(form,image)
  {
    console.log(form)
    const formData = new FormData();
    formData.append("image",image);
    formData.append("date",form.date);
    formData.append("category",form.category);
    formData.append("heading",form.heading);
    formData.append("description",form.description);
   
    return this.http.put(this.baseurl+"/news/"+form.no,formData);  }

  getNews()
  {
    return this.http.get(this.baseurl+"news");
  }
  deleteNews(no)
  {
    return this.http.delete(this.baseurl+"news/"+no);
  }
  getNewsById(No)
  {
    return this.http.get(this.baseurl+"news/"+No);
  }
  getNoNews()
  {
    return this.http.get(this.baseurl+"news/no");
  }
  getTournaments()
  {
    return this.http.get(this.baseurl+"tournament");
  }
  deleteTournaments(no)
  {
    return this.http.delete(this.baseurl+"tournament/"+no);
  }
  getNoOfTournaments()
  {
    return this.http.get(this.baseurl+"tournament/no");
  }
  getTournamentById(No)
  {
    return this.http.get(this.baseurl+"tournament/"+No);
  }
  getTeams()
  {
    return this.http.get(this.baseurl+'teams');
  }
  deleteTeams(no)
  {
    return this.http.delete(this.baseurl+'teams/'+no);
  }
  getTeamById(No)
  {
    return this.http.get(this.baseurl+'teams/'+No);
  }
  getNoOfTeams()
  {
    return this.http.get(this.baseurl+'teams/no');
  }
  getPlayers()
  {
    return this.http.get(this.baseurl+'player');
  }
  getPlayerById(no)
  {
    return this.http.get(this.baseurl+'player/'+no);
  }
  deletePlayerById(no)
  {
    return this.http.delete(this.baseurl+'player/'+no);
  }
  getNoOfPlayers()
  {
    return this.http.get(this.baseurl+'player/no');
  }
  getMatch()
  {
    return this.http.get(this.baseurl+'match');
  }
  getNoOfMatch()
  {
    return this.http.get(this.baseurl+'match/no');
  }

  getMatchById(No)
  {
    return this.http.get(this.baseurl+'match/'+No);
  }
  deleteMatchById(No)
  {
    return this.http.delete(this.baseurl+'match/'+No);
  }
}
