package com.app.pojos;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Teams")
public class Teams {

	private Integer id;
	private String name, location, owner, coach;
	private byte[] logo;
	private Set<Tournaments> tournament = new HashSet<>();
	private List<Players> players = new ArrayList<>();

	public Teams() {
	}



	public Teams(String name, String location, String owner, String coach, byte[] logo, Set<Tournaments> tournament,
			List<Players> players) {
		super();
		this.name = name;
		this.location = location;
		this.owner = owner;
		this.coach = coach;
		this.logo = logo;
		this.tournament = tournament;
		this.players = players;
	}



	public Teams(String name, String location, String owner, String coach) {
		super();
		this.name = name;
		this.location = location;
		this.owner = owner;
		this.coach = coach;
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
	@JsonIgnore
	public Set<Tournaments> getTournament() {
		return tournament;
	}

	public void setTournament(Set<Tournaments> tournament) {
		this.tournament = tournament;
	}

	// helper methods
	public void addTournament(Tournaments t) {
		tournament.add(t);
		t.getParticipatingTeams().add(this);
	}

	public void removeTournament(Tournaments t) {
		tournament.remove(t);
		t.getParticipatingTeams().remove(this);
	}

	@OneToMany(mappedBy = "teamId", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	@JsonIgnore
	public List<Players> getPlayers() {
		return players;
	}

	public void setPlayers(List<Players> players) {
		this.players = players;
	}

	// helper methods
	public void addPlayer(Players p) {
		players.add(p);
		p.setTeamId(this);
	}

	public void removePlayer(Players p) {
		players.remove(p);
		p.setTeamId(null);
	}



	@Override
	public String toString() {
		return "Teams [id=" + id + ", name=" + name + ", location=" + location + ", owner=" + owner + ", coach=" + coach
				+ ", logo=" + Arrays.toString(logo) + ", tournament=" + tournament + ", players=" + players + "]";
	}

}
