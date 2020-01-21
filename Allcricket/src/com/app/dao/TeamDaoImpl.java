package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Teams;

@Repository // To tell SC , whatever follows is a DAO layer
//apply exception translation mechanism(translates hibernate specific excs
//to spring's un chekced excs --for uniform handling across multiple JPA vendors
//(DataAccessException)
@Transactional // to enable auto tx management
public class TeamDaoImpl implements ITeamDao{
	// dependency SF
		@Autowired // byType , mandatory
		private SessionFactory sf;
		// SC tries to search for any spring bean that has implemented SF i/f
		// o.s.orm.hibernate5.LocalSessionFactoryBean
		// (alrdy confgiured in xml file)


		@Override
		public List<Teams> getAllTeams() {
			String jpql = "select t from Teams t";
			return sf.getCurrentSession().createQuery(jpql, Teams.class).getResultList();
		}
		
		@Override
		public Teams addNewTeams(Teams t) {
			sf.getCurrentSession().persist(t);
			return t;
		}
		
		@Override
		public void deleteTeams(Teams t) {
			sf.getCurrentSession().delete(t);		
		}
		
		@Override
		public Teams getTeamsById(int teamId) {
			return sf.getCurrentSession().get(Teams.class, teamId);
		}
}
