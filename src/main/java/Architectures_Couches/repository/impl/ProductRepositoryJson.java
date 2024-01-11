package Architectures_Couches.repository.impl;

import Architectures_Couches.model.Product;
import Architectures_Couches.model.User;
import Architectures_Couches.repository.ProductRepository;
import Architectures_Couches.utils.persistence.GenericRepository;

public class ProductRepositoryJson extends GenericRepository<Product> implements ProductRepository{

	public ProductRepositoryJson(String jsonFilePath) {
		super(jsonFilePath);
	}

	@Override
	public Product getByName(String name) {
		
		Product result = null;
		for (Product p : this.data) {
			if (p.getName().equals(name))
				result = p;
		}
		return result;
	}
// LE GETNAME vient du MODEL PRODUCT, LE GETTER SETTER  DU PARAMETRE "NAME"
	
// CETTE METHODE IMPLEMENTEE ICI VIENT DE L'INTERFACE PRODUCT REPOSITORY.
}
//return this.retrieve().stream().filter(p->p.getId().equals(id)).findFirst().orElse()null;