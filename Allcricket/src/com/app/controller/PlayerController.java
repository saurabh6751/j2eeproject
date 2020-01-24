package com.app.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.PlayerType;
import com.app.pojos.Players;
import com.app.pojos.Teams;
import com.app.service.IPlayerService;
import com.app.service.ITeamService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/player")
public class PlayerController {
	@Autowired
	private IPlayerService service;
	@Autowired
	private ITeamService s;

	@PostConstruct
	public void init() {
		System.out.println("in init " + service);
	}

	@GetMapping
	public ResponseEntity<?> listPlayers() {
		System.out.println("in list players");
		List<Players> allPlayers = service.getAllPlayers();
		if (allPlayers.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Players>>(allPlayers, HttpStatus.OK);
	}
	
	@GetMapping("/no")
	public ResponseEntity<?> noPlayers() {
		System.out.println("in list players");
		List<Players> allPlayers = service.getAllPlayers();
		int no = allPlayers.size();
	    return ResponseEntity.ok(Collections.singletonMap("count", no));
			
	}

	@GetMapping("/{player_id}")
	public ResponseEntity<?> getPlayerDetails(@PathVariable int player_id) {
		System.out.println("in player dtls " + player_id);
		Players p = service.getPlayersById(player_id);
		if (p == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Players>(p, HttpStatus.OK);
	}
	@GetMapping("/search/{name}")
	public ResponseEntity<?> getPlayerDetails(@PathVariable String name) {
		System.out.println("in player dtls " + name);
		List<Players> allPlayers = service.getPlayersByNAme(name);
		if (allPlayers.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Players>>(allPlayers, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<?> addPlayerDetails(@RequestParam String name,@RequestParam int age,@RequestParam String contact,@RequestParam String dob,@RequestParam String role,@RequestParam int teamId,@RequestParam MultipartFile logo)
	{

		try {
			Date dob2=new SimpleDateFormat("yyyy-MM-dd").parse(dob);
			PlayerType role2 = PlayerType.valueOf(role);
			System.out.println(role2);
			Players m1 = new Players(age,name,contact,dob2,role2);

			if(logo!=null)
			{
				m1.setPhoto(logo.getBytes());
			}
			Teams team = s.getTeamsById(teamId);
			team.addPlayer(m1);
			HttpHeaders h = new HttpHeaders();
			return new ResponseEntity<Players>(service.addNewPlayers(m1),HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{player_id}")
	public ResponseEntity<Void> deletePlayerDetails(@PathVariable int player_id) {
		System.out.println("del player dtls " + player_id);
		service.deletePlayers(player_id);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	@PutMapping("/{player_id}")
	public ResponseEntity<?> UpdatePlayerDetails(@RequestParam String playerName,@RequestParam Integer age,
			@RequestParam String contact,@RequestParam(value = "playerPhoto", required = false) MultipartFile playerPhoto,
			@RequestParam String dob,@RequestParam String role,@RequestParam Teams teamId,@PathVariable int player_id)  {

		try {
			System.out.println("in update player " + player_id + " " + playerName + " " + age+" "+ contact +" "+ dob +" "+ role +" "+ teamId );

			Players playerDetails = service.getPlayersById(player_id);
			if (playerDetails == null)
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			Date dob2=new SimpleDateFormat("yyyy-MM-dd").parse(dob);
			PlayerType role2 = PlayerType.valueOf(role);
			playerDetails.setName(playerName);
			playerDetails.setAge(age);
			playerDetails.setContact(contact);
			playerDetails.setDob(dob2);
			playerDetails.setRole(role2);
			playerDetails.setTeamId(teamId);
			if (playerPhoto != null) { // image is supplied
				playerDetails.setPhoto(playerPhoto.getBytes());
			}
			return new ResponseEntity<Players>(service.updatePlayerDetails(playerDetails), HttpStatus.OK);
		} catch (Exception e1) {
			e1.printStackTrace();// only for debugging
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
