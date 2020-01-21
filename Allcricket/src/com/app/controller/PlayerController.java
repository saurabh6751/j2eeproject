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

import com.app.pojos.Players;
import com.app.service.IPlayerService;

@RestController // @Controller + @RespBody
@CrossOrigin//(origins="http://localhost:4200")
@RequestMapping("/player")
public class PlayerController {
	@Autowired
	private IPlayerService service;

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

	@GetMapping("/{player_id}")
	public ResponseEntity<?> getPlayerDetails(@PathVariable int player_id) {
		System.out.println("in player dtls " + player_id);
		Players p = service.getPlayersById(player_id);
		if (p == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Players>(p, HttpStatus.OK);
	}
}
