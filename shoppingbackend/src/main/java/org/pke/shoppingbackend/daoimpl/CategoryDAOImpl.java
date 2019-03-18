/**
 * 
 */
package org.pke.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.pke.shoppingbackend.dao.CategoryDAO;
//import org.pke.shoppingbackend.dao.Category;
import org.pke.shoppingbackend.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author priyanka
 *
 */

@Repository("categoryDAO")
@Transactional

public class CategoryDAOImpl implements CategoryDAO {

	/* (non-Javadoc)
	 * @see org.pke.shoppingbackend.dao.CategoryDAO#list()
	 */

	@Autowired
	private SessionFactory sessionFactory;

	/*	private static List<Category> categories=new ArrayList<>();
	 */	
	/*static {

		Category category=new Category();
		adding first catgeory

		category.setId(1);
		category.setName("Flowers");
		category.setDescription("This is some description");
		category.setImageURL("CAT_1.png");

		categories.add(category);

		 category=new Category();
				adding second catgeory

				category.setId(1);
				category.setName("Pets");
				category.setDescription("This is some description");
				category.setImageURL("CAT_1.png");

				categories.add(category);

				category=new Category();
						adding first catgeory

						category.setId(1);
						category.setName("Food");
						category.setDescription("This is some description");
						category.setImageURL("CAT_1.png");

						categories.add(category);

	}

	 */
	public List<Category> list() {
		
		String selectAllCategories="FROM Category WHERE active =:active";
		
		Query query=sessionFactory.getCurrentSession().createQuery(selectAllCategories);
		
		
		query.setParameter("active",true);
		
		
		return query.getResultList();
	}

	//getting a single category	

	@Override
	public Category get(int id) {
		/*for(Category category:categories)
		{
			if(category.getId()==id)
				return category;
		}*/

		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));


	}


	@Override
	public boolean add(Category category) {

		try {
			sessionFactory.getCurrentSession().persist(category);;
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;

		}
	}


	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);;
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;

		}	}


	/*
	 * updating a category
	 * (non-Javadoc)
	 * @see org.pke.shoppingbackend.dao.CategoryDAO#delete(org.pke.shoppingbackend.dto.Category)
	 */
	
	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);;
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;

		}	
	}

}
