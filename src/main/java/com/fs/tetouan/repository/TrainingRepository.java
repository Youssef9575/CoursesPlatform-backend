package com.fs.tetouan.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fs.tetouan.model.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {
	
	@Query("SELECT t FROM Training t WHERE t.id = :id")
	public Training findTrainingById(long id);
	
	@Query("SELECT t FROM Training t WHERE t.startdate BETWEEN :dateDebut and :dateEnd")
	public List<Training> getAllTrainingBetweenTwoDate(Date dateDebut, Date dateEnd);
	
	
	@Query("SELECT t FROM Training t WHERE t.user.id = :instructorId")
	public List<Training> findTrainingByidInstructor(long instructorId);
	
}
