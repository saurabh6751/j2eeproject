package com.app.pojos;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Table(name = "BattingScorecard")
public class BattingScorecard {

	private Integer Id;
	private Players batsmanId;
	private int runs, balls, fours, sixes;
	private Players wicketTakerId, fielderId;
	private String wicketStatus;
	private double strikeRate;
	private Scorecard battingScorecardId;

	public BattingScorecard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BattingScorecard(Players batsmanId, int runs, int balls, int fours, int sixes, Players wicketTakerId,
			Players fielderId, String wicketStatus, double strikeRate, Scorecard battingScorecardId) {
		super();
		this.batsmanId = batsmanId;
		this.runs = runs;
		this.balls = balls;
		this.fours = fours;
		this.sixes = sixes;
		this.wicketTakerId = wicketTakerId;
		this.fielderId = fielderId;
		this.wicketStatus = wicketStatus;
		this.strikeRate = strikeRate;
		this.battingScorecardId = battingScorecardId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	@Column(length = 20)
	public Integer getRuns() {
		return runs;
	}

	public void setRuns(Integer runs) {
		this.runs = runs;
	}

	@Column(length = 20)
	public Integer getBalls() {
		return balls;
	}

	public void setBalls(Integer balls) {
		this.balls = balls;
	}

	@Column(length = 20)
	public Integer getFours() {
		return fours;
	}

	public void setFours(Integer fours) {
		this.fours = fours;
	}

	@Column(length = 20)
	public Integer getSixes() {
		return sixes;
	}

	public void setSixes(Integer sixes) {
		this.sixes = sixes;
	}

	@Column(length = 20)
	public double getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(double strikeRate) {
		this.strikeRate = strikeRate;
	}
	@OneToOne
	@JoinColumn(name = "batsman_id")
	public Players getBatsmanId() {
		return batsmanId;
	}

	public void setBatsmanId(Players batsmanId) {
		this.batsmanId = batsmanId;
	}
	@OneToOne
	@JoinColumn(name = "wicket_keeper_id")
	public Players getWicketTakerId() {
		return wicketTakerId;
	}

	public void setWicketTakerId(Players wicketTakerId) {
		this.wicketTakerId = wicketTakerId;
	}
	@OneToOne
	@JoinColumn(name = "fielder_id")
	public Players getFielderId() {
		return fielderId;
	}

	public void setFielderId(Players fielderId) {
		this.fielderId = fielderId;
	}
	
	public void setRuns(int runs) {
		this.runs = runs;
	}

	public void setBalls(int balls) {
		this.balls = balls;
	}

	public void setFours(int fours) {
		this.fours = fours;
	}

	public void setSixes(int sixes) {
		this.sixes = sixes;
	}

	@Column(length = 20)
	public String getWicketStatus() {
		return wicketStatus;
	}

	public void setWicketStatus(String wicketStatus) {
		this.wicketStatus = wicketStatus;
	}
	@ManyToOne()
	@JoinColumn(name = "batting_scorecard_id")
	public Scorecard getBattingScorecardId() {
		return battingScorecardId;
	}

	public void setBattingScorecardId(Scorecard battingScorecardId) {
		this.battingScorecardId = battingScorecardId;
	}


	@Override
	public String toString() {
		return "BattingScorecard [Id=" + Id + ", batsmanId=" + batsmanId + ", runs=" + runs + ", balls=" + balls
				+ ", fours=" + fours + ", sixes=" + sixes + ", wicketTakerId=" + wicketTakerId + ", fielderId="
				+ fielderId + ", wicketStatus=" + wicketStatus + ", strikeRate=" + strikeRate + ", battingScorecardId="
				+ battingScorecardId + "]";
	}
	

}
