package com.app.pojos;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="tournaments")
public class Tournaments {

	private Integer id;
	private String name,organizer,owner;
	private byte[] logo;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date startDate;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date endDate;
	private Set<Teams> participatingTeams = new HashSet<>();
	private PointTable pointTable;
	public Tournaments() {
	}
	public Tournaments(String name, String organizer, String owner, byte[] logo, Date startDate, Date endDate,
			Set<Teams> participatingTeams, PointTable pointTable) {
		super();
		this.name = name;
		this.organizer = organizer;
		this.owner = owner;
		this.logo = logo;
		this.startDate = startDate;
		this.endDate = endDate;
		this.participatingTeams = participatingTeams;
		this.pointTable = pointTable;
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
	
	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "tournament_teams",joinColumns = @JoinColumn(name="tournament_id"),inverseJoinColumns = @JoinColumn(name="team_id"))
	public Set<Teams> getParticipatingTeams() {
		return participatingTeams;
	}
	public void setParticipatingTeams(Set<Teams> participatingTeams) {
		this.participatingTeams = participatingTeams;
	}
	@OneToOne
	@JoinColumn(name = "point_table_id")
	public PointTable getPointTable() {
		return pointTable;
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

	public void setPointTable(PointTable pointTable) {
		this.pointTable = pointTable;
	}


	@Override
	public String toString() {
		return "Tournaments [name=" + name + ", organizer=" + organizer + ", owner=" + owner + ", logo="
				+ Arrays.toString(logo) + ", startDate=" + startDate + ", endDate=" + endDate + ", participatingTeams="
				+ participatingTeams + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(logo);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((organizer == null) ? 0 : organizer.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((participatingTeams == null) ? 0 : participatingTeams.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		Tournaments other = (Tournaments) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(logo, other.logo))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (organizer == null) {
			if (other.organizer != null)
				return false;
		} else if (!organizer.equals(other.organizer))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (participatingTeams == null) {
			if (other.participatingTeams != null)
				return false;
		} else if (!participatingTeams.equals(other.participatingTeams))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	
	
}
