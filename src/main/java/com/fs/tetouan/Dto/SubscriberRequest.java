package com.fs.tetouan.Dto;

public class SubscriberRequest {
	
	private long idTraining ;
	private long numberInscrit ;
	
	public SubscriberRequest(long idTraining, long numberInscrit) {
		super();
		this.idTraining = idTraining;
		this.setNumberInscrit(numberInscrit);
	}

	public long getIdTraining() {
		return idTraining;
	}

	public void setIdTraining(long idTraining) {
		this.idTraining = idTraining;
	}

	public long getNumberInscrit() {
		return numberInscrit;
	}

	public void setNumberInscrit(long numberInscrit) {
		this.numberInscrit = numberInscrit;
	}


}
