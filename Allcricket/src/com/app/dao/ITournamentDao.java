package com.app.dao;

import java.util.List;

import com.app.pojos.Tournaments;

public interface ITournamentDao {

	List<Tournaments> getAllTournaments();
	Tournaments addNewTournaments(Tournaments t);
	void deleteTournamets(Tournaments t);
	Tournaments getTournamentsById(int tournamentId);

}
