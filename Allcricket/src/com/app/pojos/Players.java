package com.app.pojos;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name = "players")
public class Players {
	private Integer Id,age;
	private String playerName,contact;
	private byte[] playerPhoto;
	private Date dob;
	private PlayerType role;
	private Teams teamId;
	public Players() {
		// TODO Auto-generated constructor stub
	}
	public Players(Integer age, String playerName, String contact, byte[] playerPhoto, Date dob, PlayerType role,
			Teams teamId) {
		super();
		this.age = age;
		this.playerName = playerName;
		this.contact = contact;
		this.playerPhoto = playerPhoto;
		this.dob = dob;
		this.role = role;
		this.teamId = teamId;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	@Column(length = 20)
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Column(length = 30)
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	@Column(length = 30)
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Lob
	public byte[] getPlayerPhoto() {
		return playerPhoto;
	}
	public void setPlayerPhoto(byte[] playerPhoto) {
		this.playerPhoto = playerPhoto;
	}
	@Temporal(TemporalType.DATE)
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Column(length = 30)
	public PlayerType getRole() {
		return role;
	}
	public void setRole(PlayerType role) {
		this.role = role;
	}
	@ManyToOne
	@JoinColumn(name = "team_id")
	public Teams getTeamId() {
		return teamId;
	}
	public void setTeamId(Teams teamId) {
		this.teamId = teamId;
	}
	@Override
	public String toString() {
		return "Players [Id=" + Id + ", age=" + age + ", playerName=" + playerName + ", contact=" + contact
				+ ", playerPhoto=" + Arrays.toString(playerPhoto) + ", dob=" + dob + ", role=" + role + ", teamId="
				+ teamId + "]";
	}
	

	
	
}
