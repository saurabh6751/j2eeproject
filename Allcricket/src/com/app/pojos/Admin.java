package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "admin")

public class Admin {
	private int id;
	private String userName;
	private String email;
	private String password;

	public Admin() {
		super();

	}

	public Admin(String userName, String email, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	@Id
	@Column(length = 10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 20)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(length = 50, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 20, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password + "]";
	}

	

}
