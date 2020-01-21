package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping
	public ResponseEntity<?> listAdmins() {
		System.out.println("in list admins");
		List<Admin> allAdmins = service.getAllAdmins();
		if (allAdmins.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Admin>>(allAdmins, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<?> validateAdmin(@RequestBody Admin a) {
		System.out.println("in list admins"+a);
		Admin a1;
		try {
			a1 = service.validateAdmin(a);
			return new ResponseEntity<Admin>(a1, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			
		}
			
		
	}
	


}
