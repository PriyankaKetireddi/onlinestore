/**
 * 
 */
package org.pke.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.pke.shoppingbackend.dao.CategoryDAO;
import org.pke.shoppingbackend.dto.Category;
import org.springframework.stereotype.Repository;

/**
 * @author priyanka
 *
 */

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	/* (non-Javadoc)
	 * @see org.pke.shoppingbackend.dao.CategoryDAO#list()
	 */
	
	private static List<Category> categories=new ArrayList<>();
	
	static {
		
		Category category=new Category();
/*		adding first catgeory
*/		
		category.setId(1);
		category.setName("Flowers");
		category.setDescription("This is some description");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		 category=new Category();
		/*		adding second catgeory
		*/		
				category.setId(1);
				category.setName("Pets");
				category.setDescription("This is some description");
				category.setImageURL("CAT_1.png");
				
				categories.add(category);
				
				category=new Category();
				/*		adding first catgeory
				*/		
						category.setId(1);
						category.setName("Food");
						category.setDescription("This is some description");
						category.setImageURL("CAT_1.png");
						
						categories.add(category);
						
	}
	
	
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}


	@Override
	public Category get(int id) {
		for(Category category:categories)
		{
			if(category.getId()==id)
				return category;
		}
		
		return null;
	}

}
