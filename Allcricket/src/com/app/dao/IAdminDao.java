package com.app.dao;

import java.util.List;

import com.app.pojos.Admin;

public interface IAdminDao {
	List<Admin> getAllAdmins();

	Admin validateAdmin(Admin a);
}
