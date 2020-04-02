package com.fs.tetouan.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fs.tetouan.Dto.PriceRequest;
import com.fs.tetouan.model.PlanElement;
import com.fs.tetouan.model.Training;
import com.fs.tetouan.repository.TrainingRepository;


@RestController
@RequestMapping("/training/")
@CrossOrigin(origins = "*", maxAge = 3600)

public class CourseController {
	
    @Autowired
    private TrainingRepository trainingRepository;
    
    Map<Long, Double> prices ;
       
    
    @PostMapping("placeTrail")
    public Training placeOrder(@RequestBody Training training){
       System.out.println(training.getTrainingName());
       return trainingRepository.save(training);
       
    }

    @GetMapping("findAllTraining")
    public List<Training> findAllOrders(){
        return trainingRepository.findAll();
    }

    
    @GetMapping("find/{id}")
    public Training getTrainingById(@PathVariable("id") long id){
        return trainingRepository.findAllTrainingId(id);
    }
    
    
    @GetMapping("listAlltrain")
    public List<Training> getTrainingBetweenTwoDate(){
    	Date today = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
        return trainingRepository.getAllTrainingBetweenTwoDate(today, DateUtils.addMonths(new Date(), 1));
    }
    
    @GetMapping("sumPrice/{id}")
    public PriceRequest getTrainingPrice(@PathVariable("id") long id){
    	double price = 0.0 ;
        Training t = trainingRepository.findAllTrainingId(id);
        for (PlanElement plan : t.getPlan()) {
			price +=plan.getPrice() ;
		}
        return new PriceRequest(price) ;
    }
    
    
    
    
}
