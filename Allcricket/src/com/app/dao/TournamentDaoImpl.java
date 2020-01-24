package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Tournaments;

@Repository // To tell SC , whatever follows is a DAO layer
//apply exception translation mechanism(translates hibernate specific excs
//to spring's un chekced excs --for uniform handling across multiple JPA vendors
//(DataAccessException)
@Transactional // to enable auto tx management
public class TournamentDaoImpl implements ITournamentDao {
	// dependency SF
		@Autowired // byType , mandatory
		private SessionFactory sf;
		// SC tries to search for any spring bean that has implemented SF i/f
		// o.s.orm.hibernate5.LocalSessionFactoryBean
		// (alrdy confgiured in xml file)
	@Override
	public List<Tournaments> getAllTournaments() {
		String jpql = "select t from Tournaments t";
		return sf.getCurrentSession().createQuery(jpql, Tournaments.class).getResultList();
	}
	
	@Override
	public Tournaments addNewTournaments(Tournaments t) {
		sf.getCurrentSession().persist(t);
		return t;
	}
	

	@Override
	public void deleteTournamets(Tournaments t) {
		sf.getCurrentSession().delete(t);		
	}

	
	@Override
	public Tournaments getTournamentsById(int tournamentId) {
		return sf.getCurrentSession().get(Tournaments.class, tournamentId);
	}
	
	@Override
	public Tournaments updateTournamentDetails(Tournaments t) {
		sf.getCurrentSession().update(t);
		return t;
	}
}
