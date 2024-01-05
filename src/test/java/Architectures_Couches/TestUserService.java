package Architectures_Couches;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Architectures_Couches.repository.UserRepository;
import Architectures_Couches.model.User;
import Architectures_Couches.repository.impl.UserRepositoryJson;
import Architectures_Couches.service.UserService;
import Architectures_Couches.service.impl.UserServiceImpl;

public class TestUserService {	
	
	private UserRepository users = new UserRepositoryJson("data/json/users.json");
	private UserService userService = new UserServiceImpl(users);

	@BeforeEach
	void beforeEachTest() throws IOException {
		users.deleteAll();
	}

	@Test
	void testChangeMyPassword() throws Exception {
		
		// 10 fake users creation
		for (int i = 1; i < 10; i++) {
			users.create(new Architectures_Couches.model.User("user" + i, "passworduser" + i, "user" + i + "@gmail.com", true));
		}
		
		// Retrieve first fake user named user1
		Architectures_Couches.model.User user1 = users.getByLogin("user1");

		//calling service method
		userService.changeMyPassword(user1.getId(), user1.getPassword(), "newpassworduser1");
		
		//Controlling
		assertEquals("newpassworduser1", users.getByLogin("user1").getPassword());		
		
	}
	
	@Test
	void testChangeEmail() throws Exception {
		Architectures_Couches.model.User userXavier = users.create(new Architectures_Couches.model.User("xav", "1234", "xav@gmail.com", true));
		
		//Architectures_Couches.model.User userXav = users.getByLogin("xav");
		
		userService.changeMyEmail(userXavier.getId(), "xavier@gmail.com");
		
		assertEquals("xavier@gmail.com", userXavier.getEmail());
	}
	
	@Test
	void testChangeEmailBis() throws Exception {
		Architectures_Couches.model.User userZazou = users.create(new Architectures_Couches.model.User("Zazou", "5678", "zaz@gmail.com", true));
		
		userService.changeMyEmailBis(userZazou.getId(), "zazou@gmail.com");
		
		assertEquals("zazou@gmail.com", userZazou.getEmail());
		
	}
}
