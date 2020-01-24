package com.app.pojos;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Tournaments")
public class Tournaments {

	private Integer id;
	private String name,organizer,owner;
	private byte[] logo;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date startDate;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date endDate;
	private Set<Teams> participatingTeams = new HashSet<>();
	private List<Matches> matches = new ArrayList<>();
	public Tournaments() {
	}


	public Tournaments(String name, String organizer, String owner, byte[] logo, Date startDate, Date endDate,
			Set<Teams> participatingTeams, List<Matches> matches) {
		super();
		this.name = name;
		this.organizer = organizer;
		this.owner = owner;
		this.logo = logo;
		this.startDate = startDate;
		this.endDate = endDate;
		this.participatingTeams = participatingTeams;
		this.matches = matches;
	}


	public Tournaments(String name, String organizer, String owner, Date startDate, Date endDate) {
		super();
		this.name = name;
		this.organizer = organizer;
		this.owner = owner;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public Tournaments(String name, String organizer, String owner) {
		super();
		this.name = name;
		this.organizer = organizer;
		this.owner = owner;
	}


	public Tournaments(String organizer, String owner, Date startDate, Date endDate) {
		super();
		this.organizer = organizer;
		this.owner = owner;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length = 30)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 50)
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	@Column(length = 50)
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	@Lob
	public byte[] getLogo() {
		return logo;
	}
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	
	@Column(name = "start_date")
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Column(name = "end_date")
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "tournament_teams",joinColumns = @JoinColumn(name="tournament_id"),inverseJoinColumns = @JoinColumn(name="team_id"))
	@JsonIgnore
	public Set<Teams> getParticipatingTeams() {
		return participatingTeams;
	}
	public void setParticipatingTeams(Set<Teams> participatingTeams) {
		this.participatingTeams = participatingTeams;
	}
	//helper methods
	public void addTeam(Teams t)
	{
		participatingTeams.add(t);
		t.getTournament().add(this);
	}
	public void removeTeam(Teams t)
	{
		participatingTeams.remove(t);
		t.getTournament().remove(this);
	}
	@OneToMany(mappedBy = "tournamentId", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	@JsonIgnore
	public List<Matches> getMatches() {
		return matches;
	}
	public void setMatches(List<Matches> matches) {
		this.matches = matches;
	}
	//helper methods
	public void addMatch(Matches m)
	{
		matches.add(m);
		m.setTournamentId(this);;
	}
	public void removeMatch(Matches m)
	{
		matches.remove(m);
		m.setTournamentId(null);;
	}


	@Override
	public String toString() {
		return "Tournaments [id=" + id + ", name=" + name + ", organizer=" + organizer + ", owner=" + owner + ", logo="
				+ Arrays.toString(logo) + ", startDate=" + startDate + ", endDate=" + endDate + ", participatingTeams="
				+ participatingTeams + ", matches=" + matches + "]";
	}
	

	
	
}
