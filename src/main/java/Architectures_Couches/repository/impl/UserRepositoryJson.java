package Architectures_Couches.repository.impl;

import Architectures_Couches.model.User;
import Architectures_Couches.repository.UserRepository;
import Architectures_Couches.utils.persistence.GenericRepository;

public class UserRepositoryJson extends GenericRepository<User> implements UserRepository {

	public UserRepositoryJson(String jsonFilePath) {
		super(jsonFilePath);
	}

	public User getByLogin(String login) { // DEFINITION DE LA METHODE GETBYLOGIN
		
		/*
		 * A l'ancienne
		 *
			User result = null;
			for (User u : this.data) {
				if (u.getLogin().equals(login))
					result = u;
			}
		*/		
		
		//Mieux avec des stream !!
		return this.retrieve().stream().filter(p->p.getLogin().equals(login)).findFirst().orElse(null);
	}
}
