package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.News;

@Repository // To tell SC , whatever follows is a DAO layer
//apply exception translation mechanism(translates hibernate specific excs
//to spring's un chekced excs --for uniform handling across multiple JPA vendors
//(DataAccessException)
@Transactional // to enable auto tx management
public class NewsDaoImpl implements INewsDao {
	// dependency SF
		@Autowired // byType , mandatory
		private SessionFactory sf;
		


		@Override
		public List<News> getAllNews() {
			String jpql = "select n from News n";
			return sf.getCurrentSession().createQuery(jpql, News.class).getResultList();
		}

		@Override
		public News addNewNews(News n) {
			sf.getCurrentSession().persist(n);
			return n;
		}

		
		@Override
		public void deleteNews(News n) {
			sf.getCurrentSession().delete(n);
		}


		@Override
		public News getNewsById(int newsId) {
			return sf.getCurrentSession().get(News.class,newsId );
		}

		
}
