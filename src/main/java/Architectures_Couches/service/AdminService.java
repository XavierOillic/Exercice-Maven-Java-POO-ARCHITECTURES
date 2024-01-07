package Architectures_Couches.service;

import java.io.IOException;
import java.util.List;

import Architectures_Couches.model.User;

public interface AdminService {
	
	List<User> findAllUsers();
	
	void disableUser(String userId) throws Exception;
	
	void enableUser(String userId) throws Exception;

	void resetAndSendNewPasswordBis (String userId, String newPass, String oldPass) throws Exception;
	
	void resetAndSendNewPassword (String userId) throws IOException, Exception;

}
