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

import com.fs.tetouan.Dto.SubscriberRequest;
import com.fs.tetouan.model.Inscription;
import com.fs.tetouan.repository.InscriptionRepsitory;



@RestController
@RequestMapping("/inscription/")
@CrossOrigin(origins = "*", maxAge = 3600)

public class InscriptionController {
	
    @Autowired
    private InscriptionRepsitory inscriptionRepository;
       
    
    @PostMapping("add")
    public Inscription addInscription(@RequestBody Inscription inscription){
       return inscriptionRepository.save(inscription);
       
    }

    @GetMapping("findAllInscription")
    public List<Inscription> findAllOrders(){
        return inscriptionRepository.findAll();
    }

    
    @GetMapping("find/{id}")
    public Inscription getTrainingById(@PathVariable("id") long id){
        return inscriptionRepository.findAllInscriptionId(id);
    }
    
    @GetMapping("subscriberNumber")
    public SubscriberRequest getInscriptionNumber(@PathVariable("id") long id){
    	System.out.println(inscriptionRepository.findNumberSubscriber());
//        return new SubscriberRequest(id, inscriptionRepository.findNumberSubscriber(id)) ;
    	return null;
    }
    
}
