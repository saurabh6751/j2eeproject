package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Admin;

@Repository // To tell SC , whatever follows is a DAO layer
//apply exception translation mechanism(translates hibernate specific excs
//to spring's un chekced excs --for uniform handling across multiple JPA vendors
//(DataAccessException)
@Transactional // to enable auto tx management
public class AdminDaoImpl implements IAdminDao {
	// dependency SF
	@Autowired // byType , mandatory
	private SessionFactory sf;
	// SC tries to search for any spring bean that has implemented SF i/f
	// o.s.orm.hibernate5.LocalSessionFactoryBean
	// (alrdy confgiured in xml file)
	
	

	@Override
	public List<Admin> getAllAdmins() {
		String jpql = "select e from Admin e";
		return sf.getCurrentSession().createQuery(jpql, Admin.class).getResultList();
	}


	@Override
	public Admin validateAdmin(String email1, String pass1) {
		String jpql = "select v from Admin v where v.email=:em and v.password=:pass";
		return sf.getCurrentSession().createQuery(jpql, Admin.class).setParameter("em", email1)
				.setParameter("pass", pass1).getSingleResult();
	}

}
