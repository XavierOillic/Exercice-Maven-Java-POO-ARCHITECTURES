package Architectures_Couches.repository;

import Architectures_Couches.model.User;
import Architectures_Couches.utils.persistence.CrudRepository;

public interface UserRepository extends CrudRepository<User> {
	User getByLogin(String login);
}
