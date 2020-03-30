package com.fs.tetouan.Dto;

import com.fs.tetouan.model.Training;

public class TrainingRequest {
	
private Training training;
    
    public TrainingRequest() {
    	
    }
    
	public TrainingRequest(Training training) {
		this.training = training;
	}

	public Training getTraining() {
		return training;
	}

	public void setCustomer(Training training) {
		this.training = training;
	}

}
