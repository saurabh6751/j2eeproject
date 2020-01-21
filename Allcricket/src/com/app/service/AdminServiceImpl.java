package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.pojos.Admin;


@Service // B.L methods
@Transactional
public class AdminServiceImpl implements IAdminService {
	@Autowired
	private IAdminDao dao;

	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return dao.getAllAdmins();
	}
	@Override
	public Admin validateAdmin(Admin a) {
		
		return  dao.validateAdmin(a);
	}
	
	

}
