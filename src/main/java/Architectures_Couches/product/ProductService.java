package Architectures_Couches.product;

import java.util.List;

import Architectures_Couches.model.Product;

public interface ProductService {
	
	List <Product> findAllProducts();
	
	void addProduct (String productId) throws Exception;
	
	void deleteProduct (String productId) throws Exception;
	
	void findOne (String productId) throws Exception;
	
	void checkStockAndAdd (String productId) throws Exception;
	
	void checkPriceSale (String productId) throws Exception;

}
