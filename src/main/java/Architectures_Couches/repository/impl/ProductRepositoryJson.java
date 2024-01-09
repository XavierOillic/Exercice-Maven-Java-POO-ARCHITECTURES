package Architectures_Couches.repository.impl;

import Architectures_Couches.model.Product;
import Architectures_Couches.repository.ProductRepository;
import Architectures_Couches.utils.persistence.GenericRepository;

public class ProductRepositoryJson extends GenericRepository<Product> implements ProductRepository {

	public ProductRepositoryJson(String jsonFilePath) {
		super(jsonFilePath);
	}
	
	public Product getById(String id) {
		
		Product result = null;
		for (Product p : this.data) {
			if (p.getId().equals(id))
			result = p;
		}
		return result;
		
	}

}
//return this.retrieve().stream().filter(p->p.getId().equals(id)).findFirst().orElse()null;