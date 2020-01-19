package com.app.pojos;

import java.util.*;

import javax.persistence.*;
@Entity
@Table(name = "teams")
public class Teams {

	private Integer id;
	private String name,location,owner,coach;
	private byte[] logo;
	private Set<Tournaments> tournament = new HashSet<>();
	private List<Players> players = new ArrayList<>();
	private Set<Matches> playedMatches = new HashSet<>();

	public Teams() {
	}
	
	public Teams(String name, String location, String owner, String coach, byte[] logo, Set<Tournaments> tournament,
			List<Players> players, Set<Matches> playedMatches) {
		super();
		this.name = name;
		this.location = location;
		this.owner = owner;
		this.coach = coach;
		this.logo = logo;
		this.tournament = tournament;
		this.players = players;
		this.playedMatches = playedMatches;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length = 50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 50)
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Column(length = 50)
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	@Column(length = 50)
	public String getCoach() {
		return coach;
	}
	public void setCoach(String coach) {
		this.coach = coach;
	}
	@Lob
	public byte[] getLogo() {
		return logo;
	}
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	@ManyToMany(mappedBy = "participatingTeams")
	public Set<Tournaments> getTournament() {
		return tournament;
	}
	public void setTournament(Set<Tournaments> tournament) {
		this.tournament = tournament;
	}
	//helper methods
	public void addTournament(Tournaments t)
	{
		tournament.add(t);
		t.getParticipatingTeams().add(this);
	}
	public void removeTournament(Tournaments t)
	{
		tournament.remove(t);
		t.getParticipatingTeams().remove(this);
	}
	@OneToMany(mappedBy = "teamId",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<Players> getPlayers() {
		return players;
	}
	public void setPlayers(List<Players> players) {
		this.players = players;
	}
	//helper methods
	public void addPlayer(Players p)
	{
		players.add(p);
		p.setTeamId(this);
	}
	public void removePlayer(Players p)
	{
		players.remove(p);
		p.setTeamId(null);
	}
	
	@ManyToMany(mappedBy = "playingTeams")
	public Set<Matches> getPlayedMatches() {
		return playedMatches;
	}

	public void setPlayedMatches(Set<Matches> playedMatches) {
		this.playedMatches = playedMatches;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coach == null) ? 0 : coach.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + Arrays.hashCode(logo);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((players == null) ? 0 : players.hashCode());
		result = prime * result + ((tournament == null) ? 0 : tournament.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teams other = (Teams) obj;
		if (coach == null) {
			if (other.coach != null)
				return false;
		} else if (!coach.equals(other.coach))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (!Arrays.equals(logo, other.logo))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (players == null) {
			if (other.players != null)
				return false;
		} else if (!players.equals(other.players))
			return false;
		if (tournament == null) {
			if (other.tournament != null)
				return false;
		} else if (!tournament.equals(other.tournament))
			return false;
		return true;
	}
	
	
	
}
