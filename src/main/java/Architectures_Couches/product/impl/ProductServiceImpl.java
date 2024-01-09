package Architectures_Couches.product.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Architectures_Couches.model.Product;
import Architectures_Couches.product.ProductService;
import Architectures_Couches.repository.ProductRepository;
import Architectures_Couches.utils.randomPriceAndSale.PriceTools;
import Architectures_Couches.utils.randomPriceAndSale.SaleTools;
import Architectures_Couches.utils.security.IdTools;

public class ProductServiceImpl implements ProductService {
	
	private ProductRepository products;
	private int rdmPrice = PriceTools.generateRdmPrice();
	private int rdmSale = SaleTools.generateRdmSale();
	private String searchName;
	
	public ProductServiceImpl (ProductRepository products, String searchName) {
		this.products = products;
		this.searchName = searchName;
	}

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
	public void addProduct(String productId) throws Exception {
		Product manga = products.getById(productId);
		
		products.getById(productId);
		manga.getQuantity();
		manga.setQuantity(10);
		products.update(manga, productId);
			
	}
	
	@Override
	public void checkStockAndAdd(String productId) throws Exception {
		Product illustratedBook = products.getById(productId);
		
		products.getById(productId);
		if (illustratedBook.getInStock() == true) {
			if (illustratedBook.getQuantity() == 0) {
			illustratedBook.setQuantity(10);
			products.update(illustratedBook, productId);
		} else
			throw new Exception ("We cannot command any other books.");	
		}
	}

	@Override
	public void deleteProduct(String productId) throws Exception {
		Product comics = products.getById(productId);
		
		products.getById(productId);
		products.delete(productId);
		products.update(comics, productId);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findOne(String productId) throws Exception {
		Product bd = products.getById(productId);
		
		products.getById(productId);
		if (bd.getQuantity() >= 1) {
			if(bd.getName() == this.searchName) {
				bd.getInStock();
			} else
				throw new Exception("We haven't this One.");
		}
		
	}
	
	@Override
	public void checkPriceSale(String productId) throws Exception {
		Product collectors = products.getById(productId);
		
		products.getById(productId);
		if (collectors.getPrice() >= rdmPrice) {
			if (collectors.getSale() < rdmSale) {
				collectors.getQuantity();
				collectors.setQuantity(0);
				products.update(collectors, productId);
			}
		} else
			throw new Exception ("We will stop this reference.");	
	}

}
