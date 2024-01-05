package Architectures_Couches.utils.persistence;

import java.io.IOException;
import java.util.List;

import Architectures_Couches.model.common.BaseEntity;

public interface CrudRepository<T extends BaseEntity> {	
	T create(T entity) throws IOException;	
	List<T> retrieve();
	T getById(String id);
	void update(T entity, String id) throws Exception;
	void delete(String id) throws Exception;
	void deleteAll() throws IOException;
	int count();
}