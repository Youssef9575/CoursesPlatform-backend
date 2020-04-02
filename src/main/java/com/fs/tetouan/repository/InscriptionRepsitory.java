package com.fs.tetouan.repository ;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fs.tetouan.model.Inscription;

public interface InscriptionRepsitory extends JpaRepository<Inscription,Integer> {

	@Query("SELECT i FROM Inscription i WHERE i.id = :id")
	Inscription findAllInscriptionId(long id);
	
	@Query("SELECT count(i) FROM Inscription")
	long findNumberSubscriber();
}
