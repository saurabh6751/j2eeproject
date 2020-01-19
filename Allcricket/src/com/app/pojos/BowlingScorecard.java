package com.app.pojos;

import javax.persistence.GeneratedValue;
import javax.persistence.*;

public class BowlingScorecard {
	private Integer Id,maiden,runs,wickets,noBalls,wide;
	private String name;
	private double over,economy;
	private TeamInMatch teamInAMatchId;
	public BowlingScorecard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BowlingScorecard(Integer maiden, Integer runs, Integer wickets, Integer noBalls, Integer wide, String name,
			double over, double economy, TeamInMatch teamInAMatchId) {
		super();
		this.maiden = maiden;
		this.runs = runs;
		this.wickets = wickets;
		this.noBalls = noBalls;
		this.wide = wide;
		this.name = name;
		this.over = over;
		this.economy = economy;
		this.teamInAMatchId = teamInAMatchId;
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
	public double getOver() {
		return over;
	}
	public void setOver(double over) {
		this.over = over;
	}
	@Column(length = 30)
	public Integer getMaiden() {
		return maiden;
	}
	public void setMaiden(Integer maiden) {
		this.maiden = maiden;
	}
	@Column(length = 30)
	public Integer getRuns() {
		return runs;
	}
	public void setRuns(Integer runs) {
		this.runs = runs;
	}
	@Column(length = 30)
	public Integer getWickets() {
		return wickets;
	}
	public void setWickets(Integer wickets) {
		this.wickets = wickets;
	}
	@Column(length = 30)
	public Integer getNoBalls() {
		return noBalls;
	}
	public void setNoBalls(Integer noBalls) {
		this.noBalls = noBalls;
	}
	@Column(length = 30)
	public Integer getWide() {
		return wide;
	}
	public void setWide(Integer wide) {
		this.wide = wide;
	}
	@Column(length = 30)
	public double getEconomy() {
		return economy;
	}
	public void setEconomy(double economy) {
		this.economy = economy;
	}
	@Column(length = 30)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToOne
	@JoinColumn(name = "team_in_match_id")
	public TeamInMatch getTeamInAMatchId() {
		return teamInAMatchId;
	}
	public void setTeamInAMatchId(TeamInMatch teamInAMatchId) {
		this.teamInAMatchId = teamInAMatchId;
	}
	@Override
	public String toString() {
		return "BowlingScorecard [Id=" + Id + ", over=" + over + ", maiden=" + maiden + ", runs=" + runs + ", wickets="
				+ wickets + ", noBalls=" + noBalls + ", wide=" + wide + ", economy=" + economy + ", name=" + name + "]";
	}
	
	

}
