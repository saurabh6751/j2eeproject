package com.app.controller;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
		System.out.println("i(consumes = \"multipart/form-data\")n init " + service);
	}
	
	@GetMapping
	public ResponseEntity<?> listTournaments() {
		System.out.println("in list tournaments");
		List<Tournaments> allTournaments = service.getAllTournaments();
		if (allTournaments.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Tournaments>>(allTournaments, HttpStatus.OK);
	}
	@GetMapping("/no")
	public ResponseEntity<?> NoOfTournaments() {
		System.out.println("in list tournaments");
		List<Tournaments> allTournaments = service.getAllTournaments();
		Integer no = allTournaments.size();
		System.out.println(no);
	    return ResponseEntity.ok(Collections.singletonMap("count", no));
	}
	
	@PostMapping
	public ResponseEntity<?> addTournamentDetails(@RequestParam(required = true) String name,@RequestParam String organizer,@RequestParam String owner
			,@RequestParam MultipartFile logo,@RequestParam String startDate,@RequestParam String endDate) 
	{
		System.out.println("in add tournaments dtls " );
		try {
			Date sDate=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(startDate);
			Date eDate=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(endDate);

			Tournaments t = new Tournaments(name,organizer,owner,sDate,eDate);
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
	public ResponseEntity<Void> deleteTournamentDetails(@PathVariable int tournament_id) {
		System.out.println("del tournament dtls " + tournament_id);
		service.deleteTournamets(tournament_id);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	@PutMapping("/{tournament_id}")
	public ResponseEntity<?> UpdateTournamentDetails(@RequestParam String name,@RequestParam String organizer,
			@RequestParam String owner,@RequestParam(value = "logo", required = false) MultipartFile logo,
			@RequestParam String startDate,@RequestParam String endDate,@PathVariable int tournament_id)  {
		System.out.println("in update tournament " + tournament_id + " " + name + " " + organizer+" "+ owner +" "+ startDate +" "+ endDate);


		
		try {
			Tournaments tournamentDetails = service.getTournamentsById(tournament_id);
			if (tournamentDetails == null)
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			Date sDate=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(startDate);
			Date eDate=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(endDate);
			tournamentDetails.setName(name);
			tournamentDetails.setOrganizer(organizer);
			tournamentDetails.setOwner(owner);
			tournamentDetails.setStartDate(sDate);
			tournamentDetails.setEndDate(eDate);
			if (logo != null) { // image is supplied
				tournamentDetails.setLogo(logo.getBytes());
			}
			return new ResponseEntity<Tournaments>(service.updateTournamentDetails(tournamentDetails), HttpStatus.OK);
		} catch (Exception e1) {
			e1.printStackTrace();// only for debugging
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
