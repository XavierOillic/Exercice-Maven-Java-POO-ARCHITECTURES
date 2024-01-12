package Architectures_Couches.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Architectures_Couches.model.Product;
import Architectures_Couches.repository.ProductRepository;
import Architectures_Couches.service.ProductService;


public class ProductServiceImpl implements ProductService {
	
	private ProductRepository products;
	
	public ProductServiceImpl (ProductRepository products) {
		this.products = products;
		
	}
	
	Random rdm = new Random();

	@Override
	public List<Product> findAllProducts() {
		//List<Product> allBooks = findAllProducts();
		List<Product> allBooks = new ArrayList<>();
		for (Product framboise : allBooks) {
			System.out.println(framboise);
		}
		return allBooks;
	}
			
			
	@Override
	public void checkStockAndAdd(String productId) throws Exception {
		//int newQuantity = 0;
		
		int quantityInStock = rdm.nextInt(1, 10);
		
		Product illustratedBook = products.getById(productId);
		products.getById(productId);
		
		if (illustratedBook.getInStock() == true) {
			if (illustratedBook.getQuantity() <= 5) {
			
				for (int a = 0; a <= 3; a++) {
					int realStock = rdm.nextInt(1, 10);
				
						illustratedBook.getQuantity();
						illustratedBook.setQuantity(realStock);
						
						products.update(illustratedBook, productId);
				}
			
			illustratedBook.getQuantity();
			illustratedBook.setQuantity(50);
			products.update(illustratedBook, productId);
			
				} else if (illustratedBook.getInStock() == false) {
				
						illustratedBook.getQuantity();
						illustratedBook.setQuantity(50);
			
						products.update(illustratedBook, productId);
						
						System.out.println(illustratedBook);
			
					} else {
						throw new Exception ("We cannot command any other books.");
						}
			}
			
	}
	
	@Override
	public void checkStockAndAddBis(String productId) throws Exception {
		
		Product illustratedBook = products.getById(productId);
		//products.getById(productId);
		
		if (illustratedBook.getInStock() == true) {
			if (illustratedBook.getQuantity() <= 2) {
				
				illustratedBook.setQuantity(50);
				
				products.update(illustratedBook, productId);
				
					} else if (illustratedBook.getInStock() == false) {
			
						illustratedBook.getQuantity();
						illustratedBook.setQuantity(50);

						products.update(illustratedBook, productId);
			
						System.out.println(illustratedBook);
					}
			}
			
	}
	

	@Override
	public void modifyQuantity (String productId) throws Exception {
		
		ProductServiceImpl productServiceImpl = new ProductServiceImpl(products);
		//Product gaston = products.create(new Product("Gaston", 12, realQuantity, true));
		Product gaston = products.getById(productId);
	
					gaston.getQuantity();
					gaston.setQuantity(gaston.getQuantity() - 20) ;
					products.update(gaston, productId);
					
					System.out.println(gaston);	
			} 
	
	
	
}// FIN DE CLASSE SERVICEPRODUCTIMPL.
