package com.app.service;

import java.util.List;

import com.app.pojos.Teams;

public interface ITeamService {

	List<Teams> getAllTeams();
	Teams addNewTeams(Teams t);
	void deleteTeams(int teamId);
	Teams getTeamsById(int teamId);

}
