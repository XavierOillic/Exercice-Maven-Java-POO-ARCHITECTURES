package Architectures_Couches.service;

public interface UserService {

	void changeMyEmail(String userId, String newEmail) throws Exception;

	void changeMyPassword(String userId, String oldPass, String newPass) throws Exception;

	void changeMyEmailBis(String userId, String newEmail) throws Exception;
}
