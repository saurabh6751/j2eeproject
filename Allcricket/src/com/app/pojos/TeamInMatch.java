package com.app.pojos;

import javax.persistence.*;



public class TeamInMatch {
	private Integer id;
	private Teams teamId;
	private Matches matchId;
	private TeamType teamType;
	private BattingScorecard battingScorecard;
	private BowlingScorecard bowlingScorecard;
	public TeamInMatch() {
		// TODO Auto-generated constructor stub
	}
	
	public TeamInMatch(Teams teamId, Matches matchId, TeamType teamType, BattingScorecard battingScorecard,
			BowlingScorecard bowlingScorecard) {
		super();
		this.teamId = teamId;
		this.matchId = matchId;
		this.teamType = teamType;
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
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "team_id")
	public Teams getTeamId() {
		return teamId;
	}
	public void setTeamId(Teams teamId) {
		this.teamId = teamId;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "match_id")
	public Matches getMatchId() {
		return matchId;
	}
	public void setMatchId(Matches matchId) {
		this.matchId = matchId;
	}
	public TeamType getTeamType() {
		return teamType;
	}
	public void setTeamType(TeamType teamType) {
		this.teamType = teamType;
	}
	@OneToOne
	@JoinColumn(name = "batting_scorecard")
	public BattingScorecard getBattingScorecard() {
		return battingScorecard;
	}
	public void setBattingScorecard(BattingScorecard battingScorecard) {
		this.battingScorecard = battingScorecard;
	}
	@OneToOne
	@JoinColumn(name = "bowling_scorecard")
	public BowlingScorecard getBowlingScorecard() {
		return bowlingScorecard;
	}
	public void setBowlingScorecard(BowlingScorecard bowlingScorecard) {
		this.bowlingScorecard = bowlingScorecard;
	}

	@Override
	public String toString() {
		return "TeamInMatch [id=" + id + ", teamId=" + teamId + ", matchId=" + matchId + ", teamType=" + teamType
				+ ", battingScorecard=" + battingScorecard + ", bowlingScorecard=" + bowlingScorecard + "]";
	}
	
}
