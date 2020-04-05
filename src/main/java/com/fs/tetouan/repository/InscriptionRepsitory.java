package com.fs.tetouan.repository ;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fs.tetouan.model.CourseSubscription;

public interface InscriptionRepsitory extends JpaRepository<CourseSubscription,Integer> {

	@Query("SELECT i FROM CourseSubscription i WHERE i.id = :id")
	CourseSubscription findAllInscriptionId(long id);
	
}
