package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPlayerDao;
import com.app.pojos.Players;

@Service // B.L methods
@Transactional
public class PlayerServiceImpl implements IPlayerService{

	@Autowired
	private IPlayerDao dao;
	
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
			dao.deletePlayers(playersById);		
	}
}
