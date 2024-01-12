package Architectures_Couches;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Architectures_Couches.model.Product;
import Architectures_Couches.repository.ProductRepository;
import Architectures_Couches.repository.impl.ProductRepositoryJson;
import Architectures_Couches.service.ProductService;
import Architectures_Couches.service.impl.ProductServiceImpl;

public class TestProductService {
	
	private ProductRepository products = new ProductRepositoryJson("data/json/products.json");
	private ProductService productService = new ProductServiceImpl (products);
	
	private Random rdm = new Random();
	
	
	@BeforeEach
	void beforeEachTest() throws IOException {
		products.deleteAll();
	}
	
	@Test
	void testFindAllProducts () throws IOException {
		Product lanfeust = products.create(new Product("Tome 1", 15, 1, true));
		Product troll = products.create(new Product("Tome 1", 15, 1, true));
		Product lanfeustEtoiles = products.create(new Product("Tome 1", 15, 1, true));
		
		List<Product> listBd = products.retrieve();
		assertEquals(3, listBd.size() );
		
	}
	
	@Test
	void testCheckStockAndAdd() throws Exception {
		
		ProductServiceImpl productServiceImpl = new ProductServiceImpl(products);
		
		Product lanfeust = products.create(new Product("lanfeust", 15, 1, true));
		
		productServiceImpl.checkStockAndAdd(lanfeust.getId());
		
		assertEquals(50, products.getByName("lanfeust").getQuantity());
	
	}
	
	@Test
	void testCheckStockAndAddBis () throws Exception {
		
		ProductServiceImpl productServiceImpl = new ProductServiceImpl(products);
		
		Product lanfeust = products.create(new Product("lanfeust", 15, 1, true));
		
		productServiceImpl.checkStockAndAddBis(lanfeust.getId());
		
		assertEquals(50, products.getByName("lanfeust").getQuantity());
		
	
	}
	@Test
	void modifyQuantity () throws Exception {
		
		ProductServiceImpl productServiceImpl = new ProductServiceImpl(products);
		
		int realQuantity = rdm.nextInt(50, 80);
		int finalQuantity = realQuantity - 20;
		
		Product rome = products.create(new Product("rome", 16, realQuantity, true));
		
		productServiceImpl.modifyQuantity(rome.getId());
		
		assertEquals(finalQuantity, products.getByName("rome").getQuantity());
	}
	
	

}

