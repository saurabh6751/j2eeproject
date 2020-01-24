import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LiveScoresComponent } from './live-scores/live-scores.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { NewsComponent } from './news/news.component';
import { SeriesComponent } from './series/series.component';
import { TeamComponent } from './team/team.component';
import { RankingsComponent } from './rankings/rankings.component';
import { LoginComponent } from './login/login.component';
import { RouterModule } from '@angular/router';
import { PintstableComponent } from './pintstable/pintstable.component';
import { HomepageComponent } from './homepage/homepage.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { AddnewmatchComponent } from './addnewmatch/addnewmatch.component';
import { AddnewteamComponent } from './addnewteam/addnewteam.component';
import { AddnewplayerComponent } from './addnewplayer/addnewplayer.component';
import { PlayerlistComponent } from './playerlist/playerlist.component';
import { TournamentlistComponent } from './tournamentlist/tournamentlist.component';
import { MatchlistComponent } from './matchlist/matchlist.component';
import { TeamlistComponent } from './teamlist/teamlist.component';
import { AddnewsComponent } from './addnews/addnews.component';
import { AddnewtournamentComponent } from './addnewtournament/addnewtournament.component';
import { AdminstartpageComponent } from './adminstartpage/adminstartpage.component';
import { AddpintstableComponent } from './addpintstable/addpintstable.component';
import { AdmintournamentComponent } from './admintournament/admintournament.component';
import { AdminmatchComponent } from './adminmatch/adminmatch.component';
import { AdminteamComponent } from './adminteam/adminteam.component';
import { AdminplayerComponent } from './adminplayer/adminplayer.component';
import { AdminnewsComponent } from './adminnews/adminnews.component';
import { AdminpointstableComponent } from './adminpointstable/adminpointstable.component';
import { AuthService } from './auth-service.service';
import { EditnnewsComponent } from './editnnews/editnnews.component';
import { EdittournamentComponent } from './edittournament/edittournament.component';
import { EditpointtableComponent } from './editpointtable/editpointtable.component';
import { EditteamsComponent } from './editteams/editteams.component';
import { EditplayersComponent } from './editplayers/editplayers.component';
import { EditmatchComponent } from './editmatch/editmatch.component';
import { PlayersComponent } from './players/players.component';
import { PlayercardComponent } from './playercard/playercard.component';
import { PlayerinfoComponent } from './playerinfo/playerinfo.component';
import { ContactusComponent } from './contactus/contactus.component';
import { TornamentmatchesComponent } from './tornamentmatches/tornamentmatches.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { NewsInfoComponent } from './news-info/news-info.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LiveScoresComponent,
    ScheduleComponent,
    NewsComponent,
    SeriesComponent,
    TeamComponent,
    RankingsComponent,
    LoginComponent,
    PintstableComponent,
    HomepageComponent,
    AdminhomeComponent,
    AddnewmatchComponent,
    AddnewteamComponent,
    AddnewplayerComponent,
    PlayerlistComponent,
    TournamentlistComponent,
    MatchlistComponent,
    TeamlistComponent,
    AddnewsComponent,
    AddnewtournamentComponent,
    AdminstartpageComponent,
    AddpintstableComponent,
    AdmintournamentComponent,
    AdminmatchComponent,
    AdminteamComponent,
    AdminplayerComponent,
    AdminnewsComponent,
    AdminpointstableComponent,
    EditnnewsComponent,
    EdittournamentComponent,
    EditpointtableComponent,
    EditteamsComponent,
    EditplayersComponent,
    EditmatchComponent,
    PlayersComponent,
    PlayercardComponent,
    PlayerinfoComponent,
    ContactusComponent,
    TornamentmatchesComponent,
    NewsInfoComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    RouterModule.forRoot([
      {
        path: "", component: HomeComponent,
        children:
          [
            { path: "", component: HomepageComponent },
            { path: "home", component: HomepageComponent },
            { path: "livescores", component: LiveScoresComponent },
            { path: "schedule", component: ScheduleComponent },
            { path: "news", component: NewsComponent },
            { path: "newsinfo/:No", component: NewsInfoComponent },
            { path: "series", component: SeriesComponent },
            { path: "pointstable", component: PintstableComponent },
            { path: "teams", component: TeamComponent },
            { path: "teaminfo/:No",component: TeamlistComponent},
            { path: "rankings", component: RankingsComponent },
            { path: "players", component: PlayersComponent },
            { path: "search", component: PlayercardComponent},
            { path:"playerinfo/:No", component: PlayerinfoComponent},
            { path: "contactus", component: ContactusComponent},
            { path: 'tournamentinfo/:No', component: TornamentmatchesComponent}]
            
      },
      { path: "admin", component: LoginComponent },
      {
        path: "admin/home", component: AdminhomeComponent , canActivate:[AuthService],
        children:
          [
            { path: "", component: AdminstartpageComponent  ,canActivate:[AuthService]},
            { path: "addnewnews", component: AddnewsComponent ,canActivate:[AuthService]},
            { path: "addnewtournament", component: AddnewtournamentComponent,canActivate:[AuthService] },
            { path: "addnewmatch", component: AddnewmatchComponent,canActivate:[AuthService] },
            { path: "addnewteam", component: AddnewteamComponent,canActivate:[AuthService] },
            { path: "addnewplayer", component: AddnewplayerComponent ,canActivate:[AuthService]},
            { path: "addpointstable",component: AddpintstableComponent,canActivate:[AuthService]},
            { path: "editnews/:no", component: EditnnewsComponent ,canActivate:[AuthService]},
            { path: "edittournament/:no", component: EdittournamentComponent,canActivate:[AuthService] },
            { path: "editmatch/:no", component: EditmatchComponent,canActivate:[AuthService] },
            { path: "editteam/:no", component: EditteamsComponent,canActivate:[AuthService] },
            { path: "editplayer/:no", component: EditplayersComponent ,canActivate:[AuthService]},
            { path: "editpointstable/:no",component: EditpointtableComponent,canActivate:[AuthService]},
            { path: "news", component: AdminnewsComponent,canActivate:[AuthService] },
            { path: "series", component: AdmintournamentComponent,canActivate:[AuthService] },
            { path: "pointstable", component: AdminpointstableComponent,canActivate:[AuthService] },
            { path: "teams", component: AdminteamComponent,canActivate:[AuthService] },
            { path: "player", component: AdminplayerComponent,canActivate:[AuthService] },
            { path: "match", component:AdminmatchComponent,canActivate:[AuthService]}]
      },
      { path:"**",component:PageNotFoundComponent}


    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
