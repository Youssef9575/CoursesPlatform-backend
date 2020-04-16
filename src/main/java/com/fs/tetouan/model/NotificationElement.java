package com.fs.tetouan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class NotificationElement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ; 
	@Column
	private String content ;
	@Column
	private String subject ;

	@Column
	private boolean isreaded ;
	
	
	public boolean getIsreaded() {
		return isreaded;
	}

	public void setIsreaded(boolean isreaded) {
		this.isreaded = isreaded;
	}
	@ManyToOne
	@JoinColumn
	private User user ;
	
	public NotificationElement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotificationElement(String content, String subject, User user ) {
		super();
		this.content = content;
		this.subject = subject;
		this.user = user;
		this.isreaded = false ;
	}
	
	
	


	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
}
