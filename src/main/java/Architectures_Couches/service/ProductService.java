package Architectures_Couches.service;

import java.util.List;

import Architectures_Couches.model.Product;

public interface ProductService {
	
	List <Product> findAllProducts();
	
	void modifyQuantity (String id) throws Exception ;
	
	void checkStockAndAdd (String id) throws Exception;
	
	void checkStockAndAddBis (String id) throws Exception;
	
	/*void checKSale (String productId) throws Exception;*/

}
