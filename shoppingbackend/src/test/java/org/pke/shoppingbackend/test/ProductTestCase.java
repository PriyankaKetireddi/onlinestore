package org.pke.shoppingbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.pke.shoppingbackend.dao.ProductDAO;
import org.pke.shoppingbackend.dto.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	
	private Product product;

	@BeforeClass
	public static void init()
	{
		context =new AnnotationConfigApplicationContext();
		context.scan("org.pke.shoppingbackend");
		context.refresh();
		productDAO =(ProductDAO)context.getBean("productDAO");
		
	}
//	
//	@Test
//	public void testCRUDProduct()
//	{
//		//create operation
//		product=new Product();
//		
//		product.setName("Lillies");
//		product.setBrand("Love");
//		product.setDescription("Lillies are beautiful");
//		product.setUnitPrice(350);
//		product.setActive(true);
//		product.setCategoryId(2);
//		product.setSupplierId(2);
//		
//		assertEquals("Something went wrong while inserting a new product!",true,productDAO.add(product));
//		
//		
//		//reading and updating the category
//		
//		product =productDAO.get(2);
//		
//		product.setName("Jasmine J");
//		
//		assertEquals("Something went wrong while updating a new product!",true,productDAO.update(product));
//
//		assertEquals("Something went wrong while updating a new product!",true,productDAO.delete(product));
//
////		//list
////		assertEquals("Something went wrong while updating a new product!",3,productDAO.list().size());
//
//	}
	
	/*@Test
	public void testListActiveProducts()
	{
		assertEquals("Something went wrong while updating a new product!",4,productDAO.listActiveProducts().size());
	}*/
	

	/*@Test
	public void testListActiveProductsByCategory()
	{
		assertEquals("Something went wrong while updating a new product!",3,productDAO.listActiveProductsByCategory(2).size());
	}*/

	/*@Test
	public void testListActiveProductsByCount()
	{
		assertEquals("Something went wrong while updating a new product!",3,productDAO.getLatestActiveProduct(3).size());
	}*/
	
}
