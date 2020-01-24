package com.app.dao;

import java.util.List;

import com.app.pojos.Teams;

public interface ITeamDao {

	List<Teams> getAllTeams();
	Teams addNewTeams(Teams t);
	void deleteTeams(Teams t);
	Teams getTeamsById(int teamId);
    Teams updateTeamDetails(Teams t);
}
