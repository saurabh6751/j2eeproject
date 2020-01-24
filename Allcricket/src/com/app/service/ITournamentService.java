package com.app.service;

import java.util.List;

import com.app.pojos.Tournaments;

public interface ITournamentService {

	List<Tournaments> getAllTournaments();
	Tournaments addTournamentDetails(Tournaments t);//t --transient 
	void deleteTournamets(int tid );
	Tournaments getTournamentsById(int tournamentId);
    Tournaments updateTournamentDetails(Tournaments t);
}
