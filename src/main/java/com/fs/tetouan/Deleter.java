package com.fs.tetouan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fs.tetouan.repository.UserRepository;

@Component
public class Deleter {
	
	@Autowired
	UserRepository repo ; 
	
	public void deteleAll () {
		repo.deleteAll();
	}
}
