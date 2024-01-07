package Architectures_Couches.service.impl;

import java.util.List;

import Architectures_Couches.model.User;
import Architectures_Couches.repository.UserRepository;
import Architectures_Couches.service.AdminService;
import Architectures_Couches.utils.persistence.CrudRepository;



public class AdminServicesImpl implements AdminService {

	private UserRepository users;

	public AdminServicesImpl(UserRepository users) {
		this.users = users;
		
	}
	
	@Override
	public List<User> findAllUsers() {
	    List<User> allUsers = findAllUsers();
	    for (User framboise : allUsers) { // j'itère dans le tableau grâce à FRAMBOISE
	    	return (List<User>) framboise;
	    } 
	    System.out.println(allUsers+"  ===> Your password has been reseted !");
	return allUsers;
	}
	
	@Override
	public void resetAndSendNewPassword(String userId) throws Exception {
		User userAdmin = users.getById(userId);
		
			userAdmin.getPassword(); // JE RECUPERE LE PASSWORD.
			userAdmin.setPassword("newPass"); // JE MODIFIE LE PASSWORD
			users.update(userAdmin, userId); // J'ENREGISTRE DANS LE REPO AVEC USERS.
			
			System.out.println(userAdmin);
			
		}
	
	@Override
	public void resetAndSendNewPasswordBis (String userId, String newPass, String oldPass) throws Exception{
		User userAdmin = users.getById(userId);
		
		if (userAdmin.getPassword() == oldPass) {
			userAdmin.setPassword(newPass);
			users.update(userAdmin, newPass);
		} else 
			throw new Exception ("Your password has been reseted !");
		System.out.println("  ===> Méthode resetAndSendNewPasswordBis : Your password has been reseted !");
			System.out.println(userAdmin);
	}
	
			
	@Override
	public void disableUser(String userId) throws Exception {
		User userAdmin = users.getById(userId);
		
			if (userAdmin.isEnable() == true) {
				userAdmin.setEnable(false);
				users.update(userAdmin, userId);
			}   else
				throw new Exception("Your account has been disabled.");
				System.out.println("  ===> Méthode DISABLE : Your account has been disabled. ");
	} 

	@Override
	public void enableUser(String userId) throws Exception {
		User userAdmin = users.getById(userId);
		
			if (userAdmin.isEnable() == false) {
				userAdmin.setEnable(true);
				users.update(userAdmin, userId);
			}   else
				throw new Exception("Your account has been enabled.");	
				System.out.println("  ===> Méthode ENABLE : Your account has been enabled. ");
	}

}
