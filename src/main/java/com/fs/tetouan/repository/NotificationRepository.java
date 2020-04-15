package com.fs.tetouan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fs.tetouan.model.NotificationElement;



public interface  NotificationRepository extends JpaRepository<NotificationElement, Long>{
	
	@Query("SELECT i FROM NotificationElement i WHERE i.user.id = :uId AND i.isreaded = false")
	public List<NotificationElement> findByUserId(Long uId);

}
