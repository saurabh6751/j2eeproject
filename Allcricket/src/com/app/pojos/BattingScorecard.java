package com.app.pojos;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BattingScorecard {
	
	private Integer Id,runs,balls,fours,sixes;
	private String name,wicketTaker,fielder,wicketStatus;
	private double strikeRate,extras;
	private TeamInMatch TeamInMatchId;
	public BattingScorecard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BattingScorecard(Integer runs, Integer balls, Integer fours, Integer sixes, String name, String wicketTaker,
			String fielder, String wicketStatus, double strikeRate, TeamInMatch teamInMatchId) {
		super();
		this.runs = runs;
		this.balls = balls;
		this.fours = fours;
		this.sixes = sixes;
		this.name = name;
		this.wicketTaker = wicketTaker;
		this.fielder = fielder;
		this.wicketStatus = wicketStatus;
		this.strikeRate = strikeRate;
		TeamInMatchId = teamInMatchId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	
	@Column(length=20)
	public Integer getRuns() {
		return runs;
	}
	public void setRuns(Integer runs) {
		this.runs = runs;
	}
	@Column(length=20)
	public Integer getBalls() {
		return balls;
	}
	public void setBalls(Integer balls) {
		this.balls = balls;
	}
	@Column(length=20)
	public Integer getFours() {
		return fours;
	}
	public void setFours(Integer fours) {
		this.fours = fours;
	}
	@Column(length=20)
	public Integer getSixes() {
		return sixes;
	}
	public void setSixes(Integer sixes) {
		this.sixes = sixes;
	}
	@Column(length=20)
	public double getStrikeRate() {
		return strikeRate;
	}
	public void setStrikeRate(double strikeRate) {
		this.strikeRate = strikeRate;
	}
	@Column(length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=20)
	public String getWicketTaker() {
		return wicketTaker;
	}
	public void setWicketTaker(String wicketTaker) {
		this.wicketTaker = wicketTaker;
	}
	@Column(length=20)
	public String getFielder() {
		return fielder;
	}
	public void setFielder(String fielder) {
		this.fielder = fielder;
	}
	@Column(length=20)
	public String getWicketStatus() {
		return wicketStatus;
	}
	public void setWicketStatus(String wicketStatus) {
		this.wicketStatus = wicketStatus;
	}
	@OneToOne
	@JoinColumn(name = "team_in_match_id")
	public TeamInMatch getTeamInMatchId() {
		return TeamInMatchId;
	}
	public void setTeamInMatchId(TeamInMatch teamInMatchId) {
		TeamInMatchId = teamInMatchId;
	}
	@Override
	public String toString() {
		return "BattingScorecard [Id=" + Id + ", runs=" + runs + ", balls=" + balls + ", fours=" + fours + ", sixes="
				+ sixes + ", strikeRate=" + strikeRate + ", name=" + name + ", wicketTaker=" + wicketTaker
				+ ", fielder=" + fielder + ", wicketStatus=" + wicketStatus + "]";
	}

}
