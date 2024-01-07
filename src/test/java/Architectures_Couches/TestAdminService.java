package Architectures_Couches;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	private AdminServicesImpl adminService = new AdminServicesImpl(users);
	

	@BeforeEach
	void beforeEachTest() throws IOException {
		users.deleteAll();
	}
	
	@Test
	void testFindAllUsers() throws IOException {
		User xav = users.create(new User("xav", "1234", "xav@gmail.com", true));
		User mathilde = users.create(new User("Stef", "p@$$w0rd", "stef@secudev.net", true));
		User jean = users.create(new User("Mina", "p@$$w0rd", "mina@secudev.net", true));
		// Je déclare Trois user dans ma LIST.
		
		List<User> allUsersTest = users.retrieve(); 
		// J'annonce ma List de User "allUsersTest", je aller "RECUPERER" mes USERS.
		
		assertEquals(3,allUsersTest.size() );
		// the Assert needs two args (expected, actual);
	}
	
	@Test
	void testResetSendNewPass() throws Exception {
		//User xav = users.create(new User("xav", "oldPass", "xav@gmail.com", true));
		User userXavier = users.create(new User("Xavier", "oldPass", "xav@gmail.com", true));
		
		adminService.resetAndSendNewPassword(userXavier.getId());
		
		assertEquals("newPass", users.getByLogin("Xavier").getPassword());
	}
	
	@Test
	void testResetSendNewPassBis() throws Exception {
	
		User userZazou = users.create(new User("Zazou", "oldPass", "xav@gmail.com", false));
		
		adminService.resetAndSendNewPassword(userZazou.getId());
		
		assertEquals("newPass", users.getByLogin("Zazou").getPassword());
		
	}
	
	@Test
	void testDisable() throws Exception {
		
		User userMarie = users.create(new User("Marie", "PassWord", "marie@gmail.com", true));
		//assertEquals(1, users.count());
		
		adminService.disableUser(userMarie.getId());

		assertEquals(false, userMarie.isEnable());
		
	}
	
	@Test
	void testEnable() throws Exception {
		
		User userMarie = users.create(new User("Marie", "PassWord", "marie@gmail.com", false));
		//assertEquals(1, users.count());
		
		adminService.enableUser(userMarie.getId());
		
		assertEquals(true, userMarie.isEnable());
		
	}
	
}
