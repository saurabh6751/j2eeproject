package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.pojos.Admin;
import com.app.service.IAdminService;

@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService service;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}

	// REST request handling method to get list of emps
	@GetMapping
	public ResponseEntity<?> listUsers() {
		System.out.println("in list users");
		List<Admin> allUsers = service.getAllAdmins();
		if (allUsers.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Admin>>(allUsers, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Admin a) {
		Admin a1 = service.validateAdmin(a);
		if (a1 == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Admin>(a1, HttpStatus.OK);
	}

	/*@PostMapping
	public ResponseEntity<?> registerUser(@RequestBody Admin u) {
		System.out.println("in add users dtls " + u);
		try {
			return new ResponseEntity<Admin>(service., HttpStatus.CREATED);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/


}
