package com.vishnu.student.pojos;

import jakarta.persistence.*;

@Entity
@Table(name="USER")
public class Users {
	@Id
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="password")
	private String password;
	
	Users(){};
	

	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
