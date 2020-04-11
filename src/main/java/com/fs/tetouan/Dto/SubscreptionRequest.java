package com.fs.tetouan.Dto;

public class SubscreptionRequest {
	
	private String city;
	private String phone;
	private String adress;
	private Long idUser ;
	private Long idTraining ;
	
	public SubscreptionRequest() {
		
	}
	
	public SubscreptionRequest(String city, String phone, String adress, Long idUser, Long idTraining) {
		super();
		this.city = city;
		this.phone = phone;
		this.adress = adress;
		this.idUser = idUser;
		this.idTraining = idTraining;
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

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdTraining() {
		return idTraining;
	}

	public void setIdTraining(Long idTraining) {
		this.idTraining = idTraining;
	}
	

}
