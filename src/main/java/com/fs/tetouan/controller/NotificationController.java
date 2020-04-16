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

import com.fs.tetouan.model.*;
import com.fs.tetouan.repository.NotificationRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/notification/")

public class NotificationController {

	@Autowired
	NotificationRepository repo;

	@GetMapping(value = "userNotification/{id}")
	public List<NotificationElement> getUserNotfications(@PathVariable("id") Long id) {
		return repo.findByUserId(id);
	}

	@PostMapping(value = "markNotificationsAsReaded")
	public boolean markNotificationsAsReaded(@RequestBody() List<Long> id) {

		System.out.println(id);
		id.forEach(nid -> {
			NotificationElement not = repo.findById(nid).get() ;
			not.setIsreaded(true);
			repo.save(not) ;
		});
		return true;
	}
}











