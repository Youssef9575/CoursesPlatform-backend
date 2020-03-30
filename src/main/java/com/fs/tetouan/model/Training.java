package com.fs.tetouan.model;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Training {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  
    private String trainingName;
    private byte [] image ;
    private String ritme;
    private String etablissement;
    private Integer nombreofhours;
    private Integer nbrparticipant;
    private String description ;
    private Date startdate ;
    private Date endDate ;
    private String [] preRequests ;
    private Integer maxSubscribers;
    
    @OneToMany(targetEntity = PlanElement.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="train_id",referencedColumnName = "id")
    private List<PlanElement> plan;
    
    public Training() {}

	public Training(String trainingName, byte[] image, String ritme, String etablissement, Integer nombreofhours,
			Integer nbrparticipant, String description, Date startdate, Date endDate, String[] preRequests,
			Integer maxSubscribers, List<PlanElement> plan) {
		super();
		this.trainingName = trainingName;
		this.image = image;
		this.ritme = ritme;
		this.etablissement = etablissement;
		this.nombreofhours = nombreofhours;
		this.nbrparticipant = nbrparticipant;
		this.description = description;
		this.startdate = startdate;
		this.endDate = endDate;
		this.preRequests = preRequests;
		this.maxSubscribers = maxSubscribers;
		this.plan = plan;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getRitme() {
		return ritme;
	}

	public void setRitme(String ritme) {
		this.ritme = ritme;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public Integer getNombreofhours() {
		return nombreofhours;
	}

	public void setNombreofhours(Integer nombreofhours) {
		this.nombreofhours = nombreofhours;
	}

	public Integer getNbrparticipant() {
		return nbrparticipant;
	}

	public void setNbrparticipant(Integer nbrparticipant) {
		this.nbrparticipant = nbrparticipant;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String[] getPreRequests() {
		return preRequests;
	}

	public void setPreRequests(String[] preRequests) {
		this.preRequests = preRequests;
	}

	public Integer getMaxSubscribers() {
		return maxSubscribers;
	}

	public void setMaxSubscribers(Integer maxSubscribers) {
		this.maxSubscribers = maxSubscribers;
	}

	public List<PlanElement> getPlan() {
		return plan;
	}

	public void setPlan(List<PlanElement> plan) {
		this.plan = plan;
	}
    
}