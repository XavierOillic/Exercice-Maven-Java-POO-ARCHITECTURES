package Architectures_Couches.service.impl;

import Architectures_Couches.model.User;
import Architectures_Couches.repository.UserRepository;
import Architectures_Couches.service.UserService;

public class UserServiceImpl implements UserService {

	private final UserRepository users;

	public UserServiceImpl(UserRepository users) {
		this.users = users;
	}

	@Override
	public void changeMyPassword(String userId, String oldPass, String newPass) throws Exception {
		User targetUser = users.getById(userId);

		// Pourquoi ce n'est pas safe de faire comme çà, avec le mot de passe en clair
		// ????? Comment devra t-on faire plus tard ?
		if (targetUser.getPassword().equals(oldPass)) {
			targetUser.setPassword(newPass);
			users.update(targetUser, userId);
		} else
			throw new Exception("bad old password");
	}

	@Override
	public void changeMyEmail(String userId, String newEmail) throws Exception {
		User targetUserFramboise = users.getById(userId);
			
			targetUserFramboise.setEmail(newEmail);	
			users.update(targetUserFramboise, userId);
		
	} 
	
	@Override
	public void changeMyEmailBis(String userId, String newEmail) throws Exception {
		User targetUserFraise = users.getById(userId);
		
		if (targetUserFraise.getEmail() != null) {
			targetUserFraise.setEmail(newEmail);
			users.update(targetUserFraise, userId);
		}
		
	}

}
