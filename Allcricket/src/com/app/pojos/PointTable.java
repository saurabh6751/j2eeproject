package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "point_table")
public class PointTable {
	
	private Integer id;
	private int played,won,lost,draw;
	private double netRR;
	private int points;
	private Teams teamId;
	private Tournaments tournamentsId;
	public PointTable() {
	}
	public PointTable(int played, int won, int lost, int draw, double netRR, int points, Teams teamId,
			Tournaments tournamentsId) {
		super();
		this.played = played;
		this.won = won;
		this.lost = lost;
		this.draw = draw;
		this.netRR = netRR;
		this.points = points;
		this.teamId = teamId;
		this.tournamentsId = tournamentsId;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length = 10)
	public int getPlayed() {
		return played;
	}
	public void setPlayed(int played) {
		this.played = played;
	}
	@Column(length = 10)
	public int getWon() {
		return won;
	}
	public void setWon(int won) {
		this.won = won;
	}
	@Column(length = 10)
	public int getLost() {
		return lost;
	}
	public void setLost(int lost) {
		this.lost = lost;
	}
	@Column(length = 10)
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	@Column(length = 20)
	public double getNetRR() {
		return netRR;
	}
	public void setNetRR(double netRR) {
		this.netRR = netRR;
	}
	@Column(length = 10)
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	@OneToOne
	@JoinColumn(name = "team_id")
	public Teams getTeamId() {
		return teamId;
	}
	public void setTeamId(Teams teamId) {
		this.teamId = teamId;
	}
	@OneToOne
	@JoinColumn(name = "tournament_id")
	public Tournaments getTournamentsId() {
		return tournamentsId;
	}
	public void setTournamentsId(Tournaments tournamentsId) {
		this.tournamentsId = tournamentsId;
	}
	@Override
	public String toString() {
		return "PointTable [id=" + id + ", played=" + played + ", won=" + won + ", lost=" + lost + ", draw=" + draw
				+ ", netRR=" + netRR + ", points=" + points + ", teamId=" + teamId + ", tournamentsId=" + tournamentsId
				+ "]";
	}
	
	

}
