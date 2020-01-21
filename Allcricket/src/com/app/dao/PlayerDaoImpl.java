package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Players;

@Repository // To tell SC , whatever follows is a DAO layer
//apply exception translation mechanism(translates hibernate specific excs
//to spring's un chekced excs --for uniform handling across multiple JPA vendors
//(DataAccessException)
@Transactional // to enable auto tx management
public class PlayerDaoImpl implements IPlayerDao{
	// dependency SF
		@Autowired // byType , mandatory
		private SessionFactory sf;
		// SC tries to search for any spring bean that has implemented SF i/f
		// o.s.orm.hibernate5.LocalSessionFactoryBean
		// (alrdy confgiured in xml file)

		@Override
		public List<Players> getAllPlayers() {

			String jpql = "select p from Players p";
			return sf.getCurrentSession().createQuery(jpql, Players.class).getResultList();
		}
		

		@Override
		public Players addNewPlayers(Players p) {
			sf.getCurrentSession().persist(p);
			return p;
		}
		
		@Override
		public void deletePlayers(Players p) {
			sf.getCurrentSession().delete(p);
			
		}
		
		@Override
		public Players getPlayersById(int playerId) {
			return sf.getCurrentSession().get(Players.class,playerId );
		}
}
