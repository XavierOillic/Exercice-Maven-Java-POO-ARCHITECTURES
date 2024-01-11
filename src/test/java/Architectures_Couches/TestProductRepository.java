package Architectures_Couches;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Architectures_Couches.model.Product;

import Architectures_Couches.repository.ProductRepository;
import Architectures_Couches.repository.impl.ProductRepositoryJson;

public class TestProductRepository {
	
	private ProductRepository products = new ProductRepositoryJson("data/json/products.json");
	
	@BeforeEach
	void beforeEachTest() throws IOException {
		products.deleteAll();
	}
	
	@Test
	void testCreateAndRetrieve() throws IOException{
		products.create(new Product("Thorgal", 13, 5, true));
		products.create(new Product("Gaston", 13, 4, true));
		
		List<Product> testList = products.retrieve();
		assertEquals(2, testList.size());
			
	}
	
	@Test
	void testUpdate () throws Exception {
		Product bd = products.create(new Product("Thorgal", 10, 2, true));
		assertEquals(10, products.getByName("Thorgal").getPrice());
		
		bd.setPrice(12);
		products.update(bd, bd.getId());
		
		assertEquals(12, products.getByName("Thorgal").getPrice());
		
	}
	
	@Test
	void testDelete () throws IOException{
		Product vagabond = products.create(new Product("Vagabond", 12, 10, true));
		Product deathNote = products.create(new Product("Death Note", 12, 8, true));
		assertEquals(2, products.count());
		
		try {
			products.delete(vagabond.getId());
			assertEquals(1, products.count());
		} catch (Exception e){
			fail(e.getMessage());
		}	
	}
	
	@Test
	void testFindByName () throws IOException {
		products.create(new Product("Goldorak", 30, 1, true));
		products.create(new Product("Kaamelott", 30, 1, true));
		
		assertNotNull(products.getByName("Goldorak"));
		assertNotNull(products.getByName("Kaamelott"));
		
		assertNull(products.getByName("Goldoraq"));
		assertNull(products.getByName("Kaamelot"));
		
	}
	
	@Test
	void testFindById() throws IOException {
		String id = products.create(new Product("Kaamelott", 300, 1, true)).getId();
		assertEquals("Kaamelott", products.getById(id).getName());
		
	}

}
