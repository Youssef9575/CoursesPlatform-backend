package com.fs.tetouan.repository ;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fs.tetouan.model.CourseSubscription;
import com.fs.tetouan.model.Training;

public interface CourseSubscriptionRepsitory extends JpaRepository<CourseSubscription,Integer> {

	@Query("SELECT i FROM CourseSubscription i WHERE i.id = :id")
	CourseSubscription findCourseSubscriptionById(long id);
	
	@Query("SELECT i FROM CourseSubscription i WHERE i.training.id = :trainId")
	List<CourseSubscription> findAllCourseSubscriptionByTrainId(long trainId);
	
	@Query("SELECT i FROM CourseSubscription i WHERE i.user.id = :userId")
	List<Training> findTrainingsByUserId(long userId);
	
	@Query("SELECT i FROM CourseSubscription i WHERE i.user.id = :trainId")
	List<CourseSubscription> findAllCourseSubscriptionByUserId(long trainId);
}
