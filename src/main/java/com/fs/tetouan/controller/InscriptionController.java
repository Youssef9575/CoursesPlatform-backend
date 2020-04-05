package com.fs.tetouan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fs.tetouan.model.CourseSubscription;
import com.fs.tetouan.model.Training;
import com.fs.tetouan.repository.InscriptionRepsitory;
import com.fs.tetouan.repository.TrainingRepository;



@RestController
@RequestMapping("/inscription/")
@CrossOrigin(origins = "*", maxAge = 3600)

public class InscriptionController {
	
    @Autowired
    private InscriptionRepsitory inscriptionRepository;
    
    @Autowired
    private TrainingRepository trainingRepository;
       
    
    @PostMapping("add")
    public CourseSubscription addInscription(@RequestBody CourseSubscription inscription){
       Optional<Training> training = trainingRepository.findById(inscription.getIdTraining()) ;
       training.get().setNbrparticipant(training.get().getNbrparticipant()+1);
       trainingRepository.save(training.get()) ;
       
       return inscriptionRepository.save(inscription);
       
    }

    @GetMapping("findAllInscription")
    public List<CourseSubscription> findAllOrders(){
        return inscriptionRepository.findAll();
    }

    
    @GetMapping("find/{id}")
    public CourseSubscription getTrainingById(@PathVariable("id") long id){
        return inscriptionRepository.findAllInscriptionId(id);
    }
    
}
