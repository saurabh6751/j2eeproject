package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IMatchDao;
import com.app.dao.ITournamentDao;
import com.app.pojos.Matches;
import com.app.pojos.Tournaments;

@Service // B.L methods
@Transactional
public class MatchServiceImpl implements IMatchService {
	@Autowired
	private IMatchDao dao;
	@Autowired
	private ITournamentDao dao2;
	
	@Override
	public List<Matches> getAllMatches() {
		// TODO Auto-generated method stub
		return dao.getAllMatches();
	}
	
	
	@Override
	public Matches addNewMatches(Matches m) {
		// TODO Auto-generated method stub
		return dao.addNewMatches(m);
	}
	

	@Override
	public Matches getMatchesById(int matchId) {
		return dao.getMatchesById(matchId);

	}
	
	
	@Override
	public void deleteMatches(int matchId) {
		Matches matchById = dao.getMatchesById(matchId);
		
		if(matchById != null)
		{
			Tournaments t = dao2.getTournamentsById(matchById.getTournamentId().getId());
			t.removeMatch(matchById);
			dao.deleteMatches(matchById);
		}
	}
	
	@Override
	public Matches updateMatchDetails(Matches m) {
		// TODO Auto-generated method stub
		return dao.updateMatchDetails(m);
	}
	
	
}
