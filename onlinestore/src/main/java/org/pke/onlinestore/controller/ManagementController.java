package org.pke.onlinestore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.pke.shoppingbackend.dao.CategoryDAO;
import org.pke.shoppingbackend.dao.ProductDAO;
import org.pke.shoppingbackend.dto.Category;
import org.pke.shoppingbackend.dto.Product;
//import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger=LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation)
	{
		
		ModelAndView mv=new ModelAndView("page");
		
		mv.addObject("userClicksManageProducts", true);
		mv.addObject("title", "Manage Products");
		Product nProduct=new Product();
			
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		mv.addObject("product", nProduct);
			
		if(operation!=null)
		{
			if(operation.equals("product"))
			{
				mv.addObject("message", "Product submitted successfully");
			}
		}
		
		return mv;
	}
	
	
	//returning categories for all the requests
	@ModelAttribute("categories")
	
	public List<Category> getCategories()
	{
		return categoryDAO.list();
	}
	
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProductSubmission(@ModelAttribute("product") Product mProduct)
	{
		logger.info(mProduct.toString());
		//create a new product record
		productDAO.add(mProduct);
		
		
		return "redirect:/manage/products?operation=product";
	}
}
