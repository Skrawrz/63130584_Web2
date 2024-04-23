package com.dodunghoctap.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dodunghoctap.models.Product;
import com.dodunghoctap.services.ProductsRepository;

@Controller
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductsRepository repo;
	
	@GetMapping({"","/"})
	public String showProductsList(Model model) {
		List<Product> products = repo.findAll();
		model.addAttribute("products",products);
		return "products/index";
	}
}
