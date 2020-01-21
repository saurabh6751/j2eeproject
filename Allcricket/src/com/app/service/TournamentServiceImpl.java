package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.dao.ITournamentDao;
import com.app.pojos.Tournaments;

@Service // B.L methods
@Transactional
public class TournamentServiceImpl implements ITournamentService {
	@Autowired
	private ITournamentDao dao;

	@Override
	public List<Tournaments> getAllTournaments() {
		// TODO Auto-generated method stub
		return dao.getAllTournaments();
	}
	
	@Override
	public Tournaments addTournamentDetails(Tournaments t) {
		// TODO Auto-generated method stub
		return dao.addNewTournaments(t);
	}
	

	@Override
	public Tournaments getTournamentsById(int tournamentId) {
		return dao.getTournamentsById(tournamentId);
	}
	

	@Override
	public void deleteTournamets(int tournamentId) {
		Tournaments tournament = dao.getTournamentsById(tournamentId);
		if(tournament != null)
			dao.deleteTournamets(tournament);
					
	}
}
