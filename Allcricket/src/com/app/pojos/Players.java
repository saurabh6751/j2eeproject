package com.app.pojos;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "Players")
public class Players {
	private Integer Id,age;
	private String name,contact;
	private byte[] photo;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dob;
	private PlayerType role;
	private Teams teamId;
	public Players() {
		// TODO Auto-generated constructor stub
	}


	public Players(Integer age, String name, String contact, Date dob, PlayerType role) {
		super();
		this.age = age;
		this.name = name;
		this.contact = contact;
		this.dob = dob;
		this.role = role;
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 30)
	public String getContact() {
		return contact;
	}
	

	public void setContact(String contact) {
		this.contact = contact;
	}
	@Lob
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	@Temporal(TemporalType.DATE)
	public Date getDob() {
		return dob;
	}
	

	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Column(length = 30)
	@Enumerated(EnumType.STRING)
	public PlayerType getRole() {
		return role;
	}
	public void setRole(PlayerType role) {
		this.role = role;
	}
	@ManyToOne()
	@JoinColumn(name = "team_id")
	public Teams getTeamId() {
		return teamId;
	}
	public void setTeamId(Teams teamId) {
		this.teamId = teamId;
	}

	@Override
	public String toString() {
		return "Players [Id=" + Id + ", age=" + age + ", name=" + name + ", contact=" + contact + ", photo="
				+ Arrays.toString(photo) + ", dob=" + dob + ", role=" + role + ", teamId=" + teamId + "]";
	}

	

	
	
}
