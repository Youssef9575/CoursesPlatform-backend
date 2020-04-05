package com.fs.tetouan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class CourseSubscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String city;
	private String phone;
	private String adress;
    private Integer idUser ;
    private Integer idTraining ;
    
	public CourseSubscription () {
		
	}

	public CourseSubscription(String city, String phone, String adress, Integer idUser, Integer idTraining) {
		this.city = city;
		this.phone = phone;
		this.adress = adress;
		this.idUser = idUser;
		this.idTraining = idTraining;
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

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdTraining() {
		return idTraining;
	}

	public void setIdTraining(Integer idTraining) {
		this.idTraining = idTraining;
	}
	
}
