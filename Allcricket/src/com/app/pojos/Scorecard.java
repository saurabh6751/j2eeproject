package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name = "Scorecard")
public class Scorecard {
	private Integer id;
	private List<BattingScorecard> battingScorecard;
	private List<BowlingScorecard> bowlingScorecard;
	private Teams teamId;
	
	public Scorecard() {
		// TODO Auto-generated constructor stub
	}
	
	public Scorecard(List<BattingScorecard> battingScorecard, List<BowlingScorecard> bowlingScorecard) {
		super();
		this.battingScorecard = battingScorecard;
		this.bowlingScorecard = bowlingScorecard;
	}
	

	public Scorecard(List<BattingScorecard> battingScorecard, List<BowlingScorecard> bowlingScorecard, Teams teamId) {
		super();
		this.battingScorecard = battingScorecard;
		this.bowlingScorecard = bowlingScorecard;
		this.teamId = teamId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@OneToMany(mappedBy = "battingScorecardId", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<BattingScorecard> getBattingScorecard() {
		return battingScorecard;
	}
	public void setBattingScorecard(List<BattingScorecard> battingScorecard) {
		this.battingScorecard = battingScorecard;
	}
	//helper methods
		public void addHomeTeamScorecard(BattingScorecard bs)
		{
			battingScorecard.add(bs);
			bs.setBattingScorecardId(this);
		}
		public void removeHomeTeamScorecard(BattingScorecard bs)
		{
			battingScorecard.remove(bs);
			bs.setBattingScorecardId(null);
		}
	@OneToMany(mappedBy = "bowlingScorecardId", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<BowlingScorecard> getBowlingScorecard() {
		return bowlingScorecard;
	}
	public void setBowlingScorecard(List<BowlingScorecard> bowlingScorecard) {
		this.bowlingScorecard = bowlingScorecard;
	}
	//helper methods
		public void addAwayTeamScorecard(BowlingScorecard bs)
		{
			bowlingScorecard.add(bs);
			bs.setBowlingScorecardId(this);
		}
		public void removeHomeTeamScorecard(BowlingScorecard bs)
		{
			bowlingScorecard.remove(bs);
			bs.setBowlingScorecardId(null);
		}
	@OneToOne
	@JoinColumn(name = "team_id")
	public Teams getTeamId() {
		return teamId;
	}

	public void setTeamId(Teams teamId) {
		this.teamId = teamId;
	}
	

	@Override
	public String toString() {
		return "Scorecard [id=" + id + ", battingScorecard=" + battingScorecard + ", bowlingScorecard="
				+ bowlingScorecard + ", teamId=" + teamId + "]";
	}

	
	
}
