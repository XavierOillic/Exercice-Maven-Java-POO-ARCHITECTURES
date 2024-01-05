package Architectures_Couches;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Architectures_Couches.model.User;
import Architectures_Couches.repository.UserRepository;
import Architectures_Couches.repository.impl.UserRepositoryJson;
import Architectures_Couches.service.AdminService;
import Architectures_Couches.service.impl.AdminServicesImpl;



public class TestAdminService {
	
	private UserRepository users = new UserRepositoryJson("data/json/users.json");
	private AdminServicesImpl adminService = new AdminServicesImpl(users, null);
	

	@BeforeEach
	void beforeEachTest() throws IOException {
		users.deleteAll();
	}
	
	@Test
	void testFindAllUsers() throws IOException {
		User mathilde = new User("Stef", "p@$$w0rd", "stef@secudev.net", true);
		User jean = new User("Mina", "p@$$w0rd", "mina@secudev.net", true);
		//List<User> allUsers =
	}

}
