package com.app.pojos;

import javax.persistence.GeneratedValue;
import javax.persistence.*;
@Entity
@Table(name = "BowlingScorecard")
public class BowlingScorecard {
	private Integer Id;
	private Players bowlerId;
	private int maiden, runs, wickets, noBalls, wide;
	private double over, economy;
	private Scorecard bowlingScorecard;

	public BowlingScorecard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BowlingScorecard(Players bowlerId, int maiden, int runs, int wickets, int noBalls, int wide, double over,
			double economy, Scorecard bowlingScorecard) {
		super();
		this.bowlerId = bowlerId;
		this.maiden = maiden;
		this.runs = runs;
		this.wickets = wickets;
		this.noBalls = noBalls;
		this.wide = wide;
		this.over = over;
		this.economy = economy;
		this.bowlingScorecard = bowlingScorecard;
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
	@OneToOne
	@JoinColumn(name = "bowler_id")
	public Players getBowlerId() {
		return bowlerId;
	}

	public void setBowlerId(Players bowlerId) {
		this.bowlerId = bowlerId;
	}
	@ManyToOne
	@JoinColumn(name = "bowling_scorecard_id")
	public Scorecard getBowlingScorecard() {
		return bowlingScorecard;
	}

	public void setBowlingScorecard(Scorecard bowlingScorecard) {
		this.bowlingScorecard = bowlingScorecard;
	}

	public void setMaiden(int maiden) {
		this.maiden = maiden;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public void setNoBalls(int noBalls) {
		this.noBalls = noBalls;
	}

	public void setWide(int wide) {
		this.wide = wide;
	}

	@Override
	public String toString() {
		return "BowlingScorecard [Id=" + Id + ", bowlerId=" + bowlerId + ", maiden=" + maiden + ", runs=" + runs
				+ ", wickets=" + wickets + ", noBalls=" + noBalls + ", wide=" + wide + ", over=" + over + ", economy="
				+ economy + ", bowlingScorecard=" + bowlingScorecard + "]";
	}
	

}
