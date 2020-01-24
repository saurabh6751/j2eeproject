package com.app.dao;

import java.util.List;

import com.app.pojos.Players;

public interface IPlayerDao {

	List<Players> getAllPlayers();
	Players addNewPlayers(Players p);
	void deletePlayers(Players p);
	Players getPlayersById(int playerId);
	List<Players> getPlayerByName(String name);
    Players updatePlayerDetails(Players p);
}
