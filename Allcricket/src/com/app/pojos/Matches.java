package com.app.pojos;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Matches")
public class Matches {

	private Integer Id;
	private String umpire;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private String location;
	private Tournaments tournamentId;
	private Scorecard homeTeamScorecard;
	private Scorecard awayTeamScorecard;
	private Teams winner;
	private Teams looser;

	public Matches() {
		// TODO Auto-generated constructor stub
	}

	public Matches(String umpire, Date date, String location, Tournaments tournamentId, Scorecard homeTeamScorecard,
			Scorecard awayTeamScorecard, Teams winner, Teams looser) {
		super();
		this.umpire = umpire;
		this.date = date;
		this.location = location;
		this.tournamentId = tournamentId;
		this.homeTeamScorecard = homeTeamScorecard;
		this.awayTeamScorecard = awayTeamScorecard;
		this.winner = winner;
		this.looser = looser;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	@Column(length = 30)
	public String getUmpire() {
		return umpire;
	}

	public void setUmpire(String umpire) {
		this.umpire = umpire;
	}

	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(length = 30)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@ManyToOne
	@JoinColumn(name = "tournament_id")
	public Tournaments getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(Tournaments tournamentId) {
		this.tournamentId = tournamentId;
	}
	@OneToOne
	@JoinColumn(name = "home_team_scorecard_id")
	public Scorecard getHomeTeamScorecard() {
		return homeTeamScorecard;
	}

	public void setHomeTeamScorecard(Scorecard homeTeamScorecard) {
		this.homeTeamScorecard = homeTeamScorecard;
	}
	@OneToOne
	@JoinColumn(name = "away_team_scorecard_id")
	public Scorecard getAwayTeamScorecard() {
		return awayTeamScorecard;
	}

	public void setAwayTeamScorecard(Scorecard awayTeamScorecard) {
		this.awayTeamScorecard = awayTeamScorecard;
	}
	@OneToOne
	@JoinColumn(name = "winner_id")
	public Teams getWinner() {
		return winner;
	}

	public void setWinner(Teams winner) {
		this.winner = winner;
	}
	@OneToOne
	@JoinColumn(name = "looser_id")
	public Teams getLooser() {
		return looser;
	}

	public void setLooser(Teams looser) {
		this.looser = looser;
	}

	@Override
	public String toString() {
		return "Matches [Id=" + Id + ", umpire=" + umpire + ", date=" + date + ", location=" + location
				+ ", tournamentId=" + tournamentId + ", homeTeamScorecard=" + homeTeamScorecard + ", awayTeamScorecard="
				+ awayTeamScorecard + ", winner=" + winner + ", looser=" + looser + "]";
	}

}
