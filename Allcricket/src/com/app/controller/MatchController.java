package com.app.controller;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
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
import com.app.pojos.Matches;
import com.app.pojos.Scorecard;
import com.app.pojos.Teams;
import com.app.pojos.Tournaments;
import com.app.service.IMatchService;
import com.app.service.ITeamService;
import com.app.service.ITournamentService;

@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/match")
public class MatchController {
	@Autowired
	private IMatchService service;
	@Autowired
	private ITournamentService s;
	@Autowired
	private ITeamService steam;

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
	@GetMapping("/no")
	public ResponseEntity<?> noMatches() {
		System.out.println("in list matches");
		List<Matches> allMatches = service.getAllMatches();
		int no = allMatches.size();
		    return ResponseEntity.ok(Collections.singletonMap("count", no));
	}
	@GetMapping("/{match_id}")
	public ResponseEntity<?> getMatchesDetails(@PathVariable int match_id) {
		System.out.println("in match dtls " + match_id);
		Matches m = service.getMatchesById(match_id);
		if (m == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Matches>(m, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<?> addMathDetails(@RequestParam(required = true) String umpire,
			@RequestParam int tournamentId,@RequestParam String location,@RequestParam String date) 
	{
		try {
			Date sDate=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(date);
			Matches m = new Matches(umpire,sDate,location);
			Tournaments t = s.getTournamentsById(tournamentId);
			t.addMatch(m);	
			return new ResponseEntity<Matches>(service.addNewMatches(m), HttpStatus.CREATED);
		} catch (Exception e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

    }
	@DeleteMapping("/{match_id}")
	public ResponseEntity<Void> deletePlayerDetails(@PathVariable int match_id) {
		System.out.println("del match dtls " + match_id);
		service.deleteMatches(match_id);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	@PutMapping("/{match_id}")
	public ResponseEntity<?> UpdateMatchDetails(@RequestBody Matches m,@PathVariable int tournament_id)  {
		System.out.println("in update tournament " +m);

		Matches matcheDetails = service.updateMatchDetails(m);
		if (matcheDetails == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
		matcheDetails.setUmpire(m.getUmpire());
		matcheDetails.setDate(m.getDate());
		matcheDetails.setLocation(m.getLocation());

		try {
			return new ResponseEntity<Matches>(service.updateMatchDetails(matcheDetails), HttpStatus.CREATED);
		} catch (Exception e1) {
			e1.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
