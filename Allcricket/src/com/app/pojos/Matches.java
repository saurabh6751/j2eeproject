package com.app.pojos;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "matches")
public class Matches {

	private Integer Id;
	private String umpire;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date date;
	private String location;
	private String result;
	private Set<Teams> playingTeams = new HashSet<>();
	public Matches() {
		// TODO Auto-generated constructor stub
	}
	
	public Matches(String umpire, Date date, String location, String result, Set<Teams> playingTeams) {
		super();
		this.umpire = umpire;
		this.date = date;
		this.location = location;
		this.result = result;
		this.playingTeams = playingTeams;
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
	public String getUmpire() {
		return umpire;
	}
	public void setUmpire(String umpire) {
		this.umpire = umpire;
	}
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Column(length = 30)
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "matches_teams",joinColumns = @JoinColumn(name="match_id"),inverseJoinColumns = @JoinColumn(name="team_id"))	public Set<Teams> getPlayingTeams() {
		return playingTeams;
	}
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setPlayingTeams(Set<Teams> playingTeams) {
		this.playingTeams = playingTeams;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((playingTeams == null) ? 0 : playingTeams.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + ((umpire == null) ? 0 : umpire.hashCode());
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
		Matches other = (Matches) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (playingTeams == null) {
			if (other.playingTeams != null)
				return false;
		} else if (!playingTeams.equals(other.playingTeams))
			return false;
		if (result != other.result)
			return false;
		if (umpire == null) {
			if (other.umpire != null)
				return false;
		} else if (!umpire.equals(other.umpire))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Matches [Id=" + Id + ", umpire=" + umpire + ", date=" + date + ", location=" + location + ", result="
				+ result + ", playingTeams=" + playingTeams + "]";
	}
	
	
	

}
