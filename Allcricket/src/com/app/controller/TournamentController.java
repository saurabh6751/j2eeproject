package com.app.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Matches;
import com.app.pojos.Teams;
import com.app.pojos.Tournaments;
import com.app.service.ITournamentService;

@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/tournament")
public class TournamentController {
	@Autowired
	private ITournamentService service;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}
	
	@GetMapping
	public ResponseEntity<?> listTournaments() {
		System.out.println("in list tournaments");
		List<Tournaments> allTournaments = service.getAllTournaments();
		if (allTournaments.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Tournaments>>(allTournaments, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addTournamentDetails(@RequestBody String name,@RequestBody String organizer,
			@RequestBody String owner,@RequestParam(value = "logo", required = false) MultipartFile logo,
			@RequestBody Date startDate,@RequestBody Date endDate)  {
		System.out.println("in add tournaments dtls " );
		try {
			Tournaments t = new Tournaments(name, organizer,owner,startDate,endDate);
			if (logo != null) {
				// image is supplied
				t.setLogo(logo.getBytes());
			}
			return new ResponseEntity<Tournaments>(service.addTournamentDetails(t), HttpStatus.CREATED);
		} catch (Exception e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

    }
	
	@GetMapping("/{tournament_id}")
	public ResponseEntity<?> getTournamentDetails(@PathVariable int tournament_id) {
		System.out.println("in tournament dtls " + tournament_id);
		Tournaments t = service.getTournamentsById(tournament_id);
		if (t == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Tournaments>(t, HttpStatus.OK);
	}
	
	@DeleteMapping("/{tournament_id}")
	public ResponseEntity<?> deleteTournamentDetails(@PathVariable int tournament_id) {
		System.out.println("in tournament dtls " + tournament_id);
		try {
			service.deleteTournamets(tournament_id);
			return new ResponseEntity<Void>( HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
			
		
	}
}
