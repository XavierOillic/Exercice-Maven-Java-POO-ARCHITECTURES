package Architectures_Couches.service;

import java.util.List;

import Architectures_Couches.model.User;

public interface AdminService {
	
	List<User> findAllUsers();

	void resetAndSendNewPassword(String userId) ;
	
	void disableUser(String userId) throws Exception;
	
	void enableUser(String userId) throws Exception;

}
