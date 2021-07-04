package com.training.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {
	@Id
	private int pid;
	@Column(length = 35)
	private String name;
	@Column(length = 6)
	private String gender;
	private long contact;
	@Column(length = 35)
	private String email;
	@Column(length = 35)
	private String teamname;
	private int age;
	@Column(length = 35)
	private String dob;
	private long score;
	
	public Player() {
		
	}
	
	
	
	public Player(int pid, String name, String gender, long contact, String email, String teamname, int age, String dob,
			long score) {
		super();
		this.pid = pid;
		this.name = name;
		this.gender = gender;
		this.contact = contact;
		this.email = email;
		this.teamname = teamname;
		this.age = age;
		this.dob = dob;
		this.score = score;
	}



	public int getPid() {
		return pid;
	}
	@Override
	public String toString() {
		return  pid + "," + name + "," + gender + "," + contact + ","
				+ email + "," + teamname + "," + age + "," + dob + "," + score ;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public long getScore() {
		return score;
	}
	public void setScore(long score) {
		this.score = score;
	} 

}
