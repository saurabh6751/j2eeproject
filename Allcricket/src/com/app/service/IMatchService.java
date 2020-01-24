package com.app.service;

import java.util.List;

import com.app.pojos.Matches;

public interface IMatchService {

	
List<Matches> getAllMatches();
	
	Matches addNewMatches(Matches m);
	
	void deleteMatches(int matchId);
	
	Matches getMatchesById(int matchId);
	
    Matches updateMatchDetails(Matches m);
}
