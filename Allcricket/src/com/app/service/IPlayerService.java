package com.app.service;

import java.util.List;

import com.app.pojos.Players;

public interface IPlayerService {

	List<Players> getAllPlayers();
	Players addNewPlayers(Players p);
	void deletePlayers(int playerId);
	Players getPlayersById(int playerId);
	List<Players> getPlayersByNAme(String name);
    Players updatePlayerDetails(Players p);
    
}
