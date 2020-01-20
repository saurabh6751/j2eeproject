package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "BowlingScorecard")
public class BowlingScorecard {
	private Integer Id;
	private Players bowlerId;
	private int maiden, runs, wickets, noBalls, wide;
	private double overs, economy;
	private Scorecard bowlingScorecardId;

	public BowlingScorecard() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public BowlingScorecard(Players bowlerId, int maiden, int runs, int wickets, int noBalls, int wide, double overs,
			double economy, Scorecard bowlingScorecardId) {
		super();
		this.bowlerId = bowlerId;
		this.maiden = maiden;
		this.runs = runs;
		this.wickets = wickets;
		this.noBalls = noBalls;
		this.wide = wide;
		this.overs = overs;
		this.economy = economy;
		this.bowlingScorecardId = bowlingScorecardId;
	}


	public double getOvers() {
		return overs;
	}

	public void setOvers(double overs) {
		this.overs = overs;
	}

	public double getEconomy() {
		return economy;
	}

	public void setEconomy(double economy) {
		this.economy = economy;
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

	@OneToOne
	@JoinColumn(name = "bowler_id")
	public Players getBowlerId() {
		return bowlerId;
	}

	public void setBowlerId(Players bowlerId) {
		this.bowlerId = bowlerId;
	}

	@ManyToOne()
	@JoinColumn(name = "bowling_scorecard_id")
	public Scorecard getBowlingScorecardId() {
		return bowlingScorecardId;
	}

	public void setBowlingScorecardId(Scorecard bowlingScorecardId) {
		this.bowlingScorecardId = bowlingScorecardId;
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

}
