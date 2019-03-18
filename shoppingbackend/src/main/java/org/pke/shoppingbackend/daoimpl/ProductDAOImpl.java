package org.pke.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.pke.shoppingbackend.dao.ProductDAO;
import org.pke.shoppingbackend.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	//Fetch product with product id
	@Override
	public Product get(int productId) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;

	}
	//List all products
	@Override
	public List<Product> list() {
		return sessionFactory.getCurrentSession().createNamedQuery("FROM Product",Product.class).getResultList();
	}

	//	Insert
	@Override
	public boolean add(Product product) {

		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	//Update	
	@Override
	public boolean update(Product product) {

		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delete(Product product) {

		try {
			product.setActive(false);
			return this.update(product);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Product> listActiveProducts() {

		String selectActiveProducts ="FROM Product Where active=:active";



		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts,Product.class).setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory ="FROM Product Where active=:active AND categoryId=:categoryId";

		
		return sessionFactory.getCurrentSession().
				createQuery(selectActiveProductsByCategory, Product.class)
				.setParameter("active", true).setParameter("categoryId", categoryId).getResultList();
	}

	@Override
	public List<Product> getLatestActiveProduct(int count) {
		return sessionFactory.getCurrentSession().
				createQuery("FROM Product where active=:active ORDER BY Id", Product.class)
				.setParameter("active", true).setFirstResult(0).setMaxResults(count)
				.getResultList();
	
	}



}
