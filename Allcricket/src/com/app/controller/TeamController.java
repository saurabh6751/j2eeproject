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

import com.app.pojos.Teams;
import com.app.service.ITeamService;

@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/team")
public class TeamController {
	@Autowired
	private ITeamService service;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}

	@GetMapping
	public ResponseEntity<?> listTeams() {
		System.out.println("in list teams");
		List<Teams> allTeams = service.getAllTeams();
		if (allTeams.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Teams>>(allTeams, HttpStatus.OK);
	}
	
	@GetMapping("/{team_id}")
	public ResponseEntity<?> getTeamDetails(@PathVariable int team_id) {
		System.out.println("in team dtls " + team_id);
		Teams t = service.getTeamsById(team_id);
		if (t == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Teams>(t, HttpStatus.OK);
	}
}
