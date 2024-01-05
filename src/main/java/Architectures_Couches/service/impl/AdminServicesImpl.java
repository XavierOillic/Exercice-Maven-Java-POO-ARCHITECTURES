package Architectures_Couches.service.impl;

import java.util.List;

import Architectures_Couches.model.Admin;
import Architectures_Couches.model.User;
import Architectures_Couches.repository.UserRepository;
import Architectures_Couches.service.AdminService;



public class AdminServicesImpl implements AdminService {
	
	private UserRepository users;
	private Admin admin;

	public AdminServicesImpl(UserRepository users, Admin admin) {
		this.users = users;
		this.admin = admin;
	}
	
	
	@Override
	public List<User> findAllUsers() {
	    List<User> allUsers = findAllUsers();
	    for (User framboise : allUsers) {
	    	return (List<User>) framboise;
	    } 
	return allUsers;
	}

	@Override
	public void resetAndSendNewPassword (String userId){
		User targetUser = users.getById(userId);
	 
	}
		
		

	@Override
	public void disableUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		
	}



}
