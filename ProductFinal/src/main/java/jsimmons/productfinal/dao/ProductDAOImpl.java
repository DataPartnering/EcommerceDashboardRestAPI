package jsimmons.productfinal.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsimmons.productfinal.model.Product;
@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public List<Product> get() {
	Session currentSession = entityManager.unwrap(Session.class);
	Query<Product> query = currentSession.createQuery("from Product", Product.class);
	List<Product> list = query.getResultList();
	return list;
	}

	@Override
	public Product get(long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Product productObj = currentSession.get(Product.class, id);
		return productObj;
	}

	@Override
	public void save(Product product) {
Session currentSession = entityManager.unwrap(Session.class);
currentSession.saveOrUpdate(product);
	}

	@Override
	public void delete(long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Product productObj = currentSession.get(Product.class, id);
		currentSession.delete(productObj);
		
	}

}
