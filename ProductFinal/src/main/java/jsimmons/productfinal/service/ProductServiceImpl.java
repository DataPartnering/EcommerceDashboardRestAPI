package jsimmons.productfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jsimmons.productfinal.dao.ProductDAO;
import jsimmons.productfinal.model.Product;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO productDAO;
	
	@Transactional
	@Override
	public List<Product> get() {
			return productDAO.get();
	}
	@Transactional
	@Override
	public Product get(long id) {
	return productDAO.get(id);
	
	}
	@Transactional
	@Override
	public void save(Product product) {
	productDAO.save(product);
		
	}
	@Transactional
	@Override
	public void delete(long id) {
	productDAO.delete(id);
	}

}
