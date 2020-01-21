package com.app.dao;

import java.util.List;

import com.app.pojos.Matches;

public interface IMatchDao {

	List<Matches> getAllMatches();
	Matches addNewMatches(Matches m);
	void deleteMatches(Matches m);
	Matches getMatchesById(int matchId);

}
