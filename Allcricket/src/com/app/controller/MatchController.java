package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Matches;
import com.app.service.IMatchService;

@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/match")
public class MatchController {
	@Autowired
	private IMatchService service;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}

	@GetMapping
	public ResponseEntity<?> listMatches() {
		System.out.println("in list matches");
		List<Matches> allMatches = service.getAllMatches();
		if (allMatches.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Matches>>(allMatches, HttpStatus.OK);
	}
	@GetMapping("/{match_id}")
	public ResponseEntity<?> getMatchesDetails(@PathVariable int match_id) {
		System.out.println("in match dtls " + match_id);
		Matches m = service.getMatchesById(match_id);
		if (m == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Matches>(m, HttpStatus.OK);
	}
	
}
