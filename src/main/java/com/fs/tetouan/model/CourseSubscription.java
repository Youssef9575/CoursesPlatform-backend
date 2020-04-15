package com.fs.tetouan.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class CourseSubscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String city;
	
	private String phone;
	
	private String adress;
	
	@ManyToOne(targetEntity = User.class,cascade = CascadeType.DETACH)
	@JoinColumn(name ="user_id",referencedColumnName = "id")
	private User user;
	
	@JsonIgnore
	@ManyToOne(targetEntity = Training.class,cascade = CascadeType.DETACH ,fetch = FetchType.LAZY)
	@JoinColumn(name ="train_id",referencedColumnName = "id")
	private Training training;

	public CourseSubscription () {
		
	}

	public CourseSubscription(String city, String phone, String adress, User user, Training training) {
		super();
		this.city = city;
		this.phone = phone;
		this.adress = adress;
		this.user = user;
		this.training = training;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}
	
}
