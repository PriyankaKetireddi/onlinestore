package org.pke.shoppingbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.pke.shoppingbackend.dao.CategoryDAO;
import org.pke.shoppingbackend.dto.Category;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	
	@BeforeClass
	public static void init()
	{
		context =new AnnotationConfigApplicationContext();
		context.scan("org.pke.shoppingbackend");
		context.refresh();
		categoryDAO =(CategoryDAO)context.getBean("categoryDAO");
		
	}
	
	/*@Test
	public void testAddCategory()
	{
		category = new Category();
		
		category.setName("Flowers");
		category.setDescription("This is some description");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside a table",true,categoryDAO.add(category));
		
	}*/
	
	
	/*@Test
	public void testCategory()
	{
		category=categoryDAO.get(1);
		
		assertEquals("Successfully fetched a single category from a table","Flowers",category.getName());
	}
	*/
	
	
	/*@Test
	public void testCategory()
	{
		category=categoryDAO.get(1);
		
		category.setName("Pets");
		assertEquals("Successfully updated a single category from a table","true",categoryDAO.update(category));
	}
	*/
	
	/*@Test
	public void testDeleteCategory()
	{
		category=categoryDAO.get(1);
		
		assertEquals("Successfully deleted a single category from a table",true,categoryDAO.delete(category));
	}*/
	
	@Test
	public void testListCategory()
	{
		
		assertEquals("Successfully fetched list of categories from a table",1,categoryDAO.list().size());
	}
	
	
}
