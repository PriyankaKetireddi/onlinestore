package org.pke.onlinestore.controller;

import org.pke.shoppingbackend.dao.CategoryDAO;
import org.pke.shoppingbackend.daoimpl.*;
import org.pke.shoppingbackend.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Home");
/*		System.out.println(CategoryDAO.list());
*/		//passing the list
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome",true);
		
		return mv;
	}
	
	/*@RequestMapping(value={"/test"})
	public ModelAndView test(@RequestParam(value="greeting",required=false)String greeting)
	{
		if(greeting==null)
		{
			greeting="Hello there";
		}
		ModelAndView mv=new ModelAndView("page");
	mv.addObject("greeting",greeting);
	return mv;
	}
	
	@RequestMapping(value={"/test/{greeting}"})
	public ModelAndView test(@PathVariable("greeting")String greeting)
	{
		if(greeting==null)
		{
			greeting="Hello there";
		}
		ModelAndView mv=new ModelAndView("page");
	mv.addObject("greeting",greeting);
	return mv;
	}*/
	@RequestMapping(value={"/about"})
	public ModelAndView about() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		
		return mv;
	}
	
	@RequestMapping(value={"/contact"})
	public ModelAndView contact() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Contact");
		mv.addObject("userClickContact",true);
		
		return mv;
	}
	
//	Method to all load products based on category
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","All Products");
/*		System.out.println(CategoryDAO.list());
*/		//passing the list
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts",true);
		
		return mv;
	}
	

	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv=new ModelAndView("page");
		//CategoryDAO to fetch single category
		
		Category category=null;
		category=categoryDAO.get(id);
		mv.addObject("title",category.getName());
/*		System.out.println(CategoryDAO.list());
*/		//passing the list
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("category", category);

		mv.addObject("userClickCategoryProducts",true);
		
		return mv;
	}
	
	
}
