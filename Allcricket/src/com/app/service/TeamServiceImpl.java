package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ITeamDao;
import com.app.pojos.Teams;

@Service // B.L methods
@Transactional
public class TeamServiceImpl implements ITeamService {
	@Autowired
	private ITeamDao dao;
	
	@Override
	public List<Teams> getAllTeams() {
		// TODO Auto-generated method stub
		return dao.getAllTeams();
	}
	
	@Override
	public Teams addNewTeams(Teams t) {
		// TODO Auto-generated method stub
		return dao.addNewTeams(t);
	}
	
	@Override
	public Teams getTeamsById(int teamId) {
		return dao.getTeamsById(teamId);

	}
	
	@Override
	public void deleteTeams(int teamId) {
		Teams teamsById = dao.getTeamsById(teamId);
		if(teamsById != null)
			dao.deleteTeams(teamsById);		
	}
	

}
