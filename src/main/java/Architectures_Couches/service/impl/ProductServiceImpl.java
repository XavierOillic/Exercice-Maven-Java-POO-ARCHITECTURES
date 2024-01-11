package Architectures_Couches.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Architectures_Couches.model.Product;
import Architectures_Couches.repository.ProductRepository;
import Architectures_Couches.service.ProductService;
import Architectures_Couches.utils.random.randomize;



public class ProductServiceImpl implements ProductService {
	
	private ProductRepository products;
	private String searchName;
	
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
		int newQuantity = 100;
		
		int quantityInStock = rdm.nextInt(1, 10);
		
		Product illustratedBook = products.getById(productId);
		products.getById(productId);
		
		if (illustratedBook.getInStock() == true) {
			if (illustratedBook.getQuantity() <= 5) {
			
				for (int a = 0; a <= 5; a++) {
					int realStock = rdm.nextInt(1, 10);
				
						illustratedBook.getQuantity();
						illustratedBook.setQuantity(realStock);
						
						products.update(illustratedBook, productId);
				}
			
			illustratedBook.getQuantity();
			illustratedBook.setQuantity(newQuantity);
			products.update(illustratedBook, productId);
			
				} else if (illustratedBook.getInStock() == false) {
				
						illustratedBook.getQuantity();
						illustratedBook.setQuantity(newQuantity);
			
						products.update(illustratedBook, productId);
						
						System.out.println(illustratedBook);
			
					} else {
						throw new Exception ("We cannot command any other books.");
						}
			}
			
	}
	
	@Override
	public void deleteProduct(String productId) throws Exception {
		Product comics = products.getById(productId);
		
		products.getById(productId);
		products.delete(productId);
		products.update(comics, productId);
		
	}

	@Override
	public void findOne(String productId) throws Exception {
		String searchName = "";
		Product bd = products.getById(productId);
		
		products.getById(productId);
		if (bd.getQuantity() >= 1) {
			if(bd.getName() == searchName) {
				bd.getInStock();
			} else
				throw new Exception("We haven't this One.");
		}
		
	}


}
