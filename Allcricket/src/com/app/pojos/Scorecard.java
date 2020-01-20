package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name = "Scorecard")
public class Scorecard {
	private Integer id;
	private List<BattingScorecard> battingScorecard;
	private List<BowlingScorecard> bowlingScorecard;
	
	public Scorecard() {
		// TODO Auto-generated constructor stub
	}
	
	public Scorecard(List<BattingScorecard> battingScorecard, List<BowlingScorecard> bowlingScorecard) {
		super();
		this.battingScorecard = battingScorecard;
		this.bowlingScorecard = bowlingScorecard;
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
	@OneToMany(mappedBy = "bowlingScorecardId", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<BowlingScorecard> getBowlingScorecard() {
		return bowlingScorecard;
	}
	public void setBowlingScorecard(List<BowlingScorecard> bowlingScorecard) {
		this.bowlingScorecard = bowlingScorecard;
	}

	@Override
	public String toString() {
		return "Scorecard [id=" + id + ", battingScorecard=" + battingScorecard + ", bowlingScorecard="
				+ bowlingScorecard + "]";
	}
	
	
}
