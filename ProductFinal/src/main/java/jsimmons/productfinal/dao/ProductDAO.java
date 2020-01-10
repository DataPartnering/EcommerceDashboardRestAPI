package jsimmons.productfinal.dao;

import java.util.List;

import jsimmons.productfinal.model.Product;

public interface ProductDAO {

	List<Product> get();
	Product get(long id);
	void save(Product product);
	void delete (long id);
}
