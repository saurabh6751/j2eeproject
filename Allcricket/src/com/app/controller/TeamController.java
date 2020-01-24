package com.app.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Teams;
import com.app.service.ITeamService;

@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/teams")
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
	
	@GetMapping("/no")
	public ResponseEntity<?> noTeams() {
		System.out.println("in list teams");
		List<Teams> allTeams = service.getAllTeams();
		int no = allTeams.size();
	    return ResponseEntity.ok(Collections.singletonMap("count", no));

	}
	
	@GetMapping("/{team_id}")
	public ResponseEntity<?> getTeamDetails(@PathVariable int team_id) {
		System.out.println("in team dtls " + team_id);
		Teams t = service.getTeamsById(team_id);
		if (t == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Teams>(t, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addTeamDetails(@RequestParam String name,@RequestParam String location,@RequestParam String owner,@RequestParam String coach,@RequestParam MultipartFile logo)
	{
		Teams m1 = new Teams(name,location,owner,coach);
		try {
			if(logo!=null)
			{
				m1.setLogo(logo.getBytes());
			}
			
			return new ResponseEntity<Teams>(service.addNewTeams(m1),HttpStatus.CREATED);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/{team_id}")
	public ResponseEntity<Void> deletePlayerDetails(@PathVariable int team_id) {
		System.out.println("del team dtls " + team_id);
		service.deleteTeams(team_id);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	@PutMapping("/{team_id}")
	public ResponseEntity<?> UpdateTournamentDetails(@RequestParam String name,
			@RequestParam String location,@RequestParam String owner,@RequestParam String coach,
			@RequestParam(value = "logo", required = false) MultipartFile logo,@PathVariable int team_id)  {
		System.out.println("in update tournament " + team_id + " " + name + " " + location+" "+ owner +" "+ coach);

		Teams teamDetails = service.getTeamsById(team_id);
		if (teamDetails == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		teamDetails.setName(name);
		teamDetails.setLocation(location);
		teamDetails.setOwner(owner);
		teamDetails.setCoach(coach);
		
		
		try {
			if (logo != null) { // image is supplied
				teamDetails.setLogo(logo.getBytes());
			}
			return new ResponseEntity<Teams>(service.updateTeamDetails(teamDetails), HttpStatus.OK);
		} catch (Exception e1) {
			e1.printStackTrace();// only for debugging
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
}
