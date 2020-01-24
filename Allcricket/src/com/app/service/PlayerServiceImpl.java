package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPlayerDao;
import com.app.dao.ITeamDao;
import com.app.pojos.Players;
import com.app.pojos.Teams;

@Service // B.L methods
@Transactional
public class PlayerServiceImpl implements IPlayerService{

	@Autowired
	private IPlayerDao dao;
	
	@Autowired
	private ITeamDao dao2;
	
	@Override
	public List<Players> getAllPlayers() {
		// TODO Auto-generated method stub
		return dao.getAllPlayers();
	}
	
	@Override
	public Players addNewPlayers(Players p) {
		// TODO Auto-generated method stub
		return dao.addNewPlayers(p);
	}
	
	@Override
	public Players getPlayersById(int playerId) {
		return dao.getPlayersById(playerId);

	}
	
	@Override
	public void deletePlayers(int playerId) {
		Players playersById = dao.getPlayersById(playerId);
		
		if(playersById != null)
		{
			Teams t = dao2.getTeamsById(playersById.getTeamId().getId());
			t.removePlayer(playersById);
			dao.deletePlayers(playersById);		
		}
	}

	@Override
	public List<Players> getPlayersByNAme(String name) {
		// TODO Auto-generated method stub
		return dao.getPlayerByName(name);
	}
	
	@Override
	public Players updatePlayerDetails(Players p) {
		// TODO Auto-generated method stub
		return dao.updatePlayerDetails(p);
	}
}
