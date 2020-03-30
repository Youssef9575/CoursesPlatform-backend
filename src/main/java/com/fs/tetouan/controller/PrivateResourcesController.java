package com.fs.tetouan.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PrivateResourcesController {

	@GetMapping("/api/test/courses")
	@PreAuthorize("hasRole('STUDENT')or hasRole('INSTRUCTOR')")
	public String userAccess() {
		return ">>> STUDENT Contents!";
	}

	@GetMapping("/api/test/insctructorBoard")
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public String projectManagementAccess() {
		return ">>> INSTRUCTOR content";
	}
}
