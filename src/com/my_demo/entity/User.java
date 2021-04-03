package com.my_demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {
	public User()
	{
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="gender")
	private Integer gender;
	
	@Column(name="number")
	private Integer number;

	@Column(name="name")
	private String name;

	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;

	@Column(name="role")
	private Integer role;

	public int getId() {
		return id;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
