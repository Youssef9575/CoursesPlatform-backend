package com.fs.tetouan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fs.tetouan.Dto.SubscreptionRequest;
import com.fs.tetouan.model.CourseSubscription;
import com.fs.tetouan.model.Training;
import com.fs.tetouan.repository.CourseSubscriptionRepsitory;
import com.fs.tetouan.repository.TrainingRepository;
import com.fs.tetouan.repository.UserRepository;



@RestController
@RequestMapping("/inscription/")
@CrossOrigin(origins = "*", maxAge = 3600)

public class CourseSubscriptionController {
	
    @Autowired
    private CourseSubscriptionRepsitory courseSubscriptionRepsitory;
    
    @Autowired
    private TrainingRepository trainingRepository;
    
    @Autowired
    private UserRepository userRepository;
       
    
    @PostMapping("add")
    public CourseSubscription addInscription(@RequestBody SubscreptionRequest inscription){
    	
       CourseSubscription courseSubscription = new CourseSubscription(inscription.getCity(), inscription.getPhone(), inscription.getAdress(), 
    		   userRepository.findUserById(inscription.getIdUser()), trainingRepository.findTrainingById(inscription.getIdTraining()));
       //update training nombre participant
       Training training = trainingRepository.findTrainingById(inscription.getIdTraining());
       training.setNbrparticipant(training.getNbrparticipant()+1);
       trainingRepository.save(training) ;
       //save Subscription to cours
       
       
       return courseSubscriptionRepsitory.save(courseSubscription);
       
    }

    @GetMapping("findAllInscription")
    public List<CourseSubscription> findAllInscription(){
        return courseSubscriptionRepsitory.findAll();
    }

    
    @GetMapping("find/{id}")
    public SubscreptionRequest getCourseSubscription(@PathVariable("id") long id){
    	CourseSubscription courseSubscription = courseSubscriptionRepsitory.findCourseSubscriptionById(id) ;
    	SubscreptionRequest subscreptionRequest = new SubscreptionRequest(courseSubscription.getCity(),
    			courseSubscription.getPhone(), courseSubscription.getAdress(), courseSubscription.getUser().getId(), courseSubscription.getTraining().getId()) ;
        return subscreptionRequest;
    }
    
    @GetMapping("findCourseSubscription/{idTrain}")
    public List<CourseSubscription> findCourseSubscription(@PathVariable("idTrain") long id){
        return courseSubscriptionRepsitory.findAllCourseSubscriptionByTrainId(id);
    }
    
    @GetMapping("findTraining/{idUser}")
    public List<Training> findUserTraining(@PathVariable("idUser") long id){
        return courseSubscriptionRepsitory.findTrainingsByUserId(id);
    }
    
}
