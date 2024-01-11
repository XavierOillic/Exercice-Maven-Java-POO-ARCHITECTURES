package Architectures_Couches.repository;

import Architectures_Couches.model.Product;
import Architectures_Couches.utils.persistence.CrudRepository;

public interface ProductRepository extends CrudRepository<Product>{
	Product getByName(String name);

}
