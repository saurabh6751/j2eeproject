package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Matches;

@Repository // To tell SC , whatever follows is a DAO layer
//apply exception translation mechanism(translates hibernate specific excs
//to spring's un chekced excs --for uniform handling across multiple JPA vendors
//(DataAccessException)
@Transactional // to enable auto tx management
public class MatchDaoImpl implements IMatchDao {
	// dependency SF
		@Autowired // byType , mandatory
		private SessionFactory sf;
		// SC tries to search for any spring bean that has implemented SF i/f
		// o.s.orm.hibernate5.LocalSessionFactoryBean
		// (alrdy confgiured in xml file)
		

		@Override
		public List<Matches> getAllMatches() {
			String jpql = "select m from Matches m";
			return sf.getCurrentSession().createQuery(jpql, Matches.class).getResultList();
		}
		

		@Override
		public Matches addNewMatches(Matches m) {
			sf.getCurrentSession().persist(m);
			return m;
		}


		@Override
		public void deleteMatches(Matches m) {
			sf.getCurrentSession().delete(m);
		}

		@Override
		public Matches getMatchesById(int matchId) {
			return sf.getCurrentSession().get(Matches.class, matchId);
		}
}
