package jsimmons.productfinal.service;

import java.util.List;

import jsimmons.productfinal.model.Product;

public interface ProductService {

	
	List<Product> get();
	Product get(long id);
	void save(Product product);
	void delete (long id);
}
