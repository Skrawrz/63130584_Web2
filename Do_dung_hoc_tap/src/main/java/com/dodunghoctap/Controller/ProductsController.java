package com.dodunghoctap.Controller;

import java.nio.file.Files;
import java.io.InputStream;
import java.nio.file.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dodunghoctap.models.Product;
import com.dodunghoctap.models.ProductsDTO;
import com.dodunghoctap.services.ProductsRepository;

import jakarta.validation.Valid;

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
	
	@GetMapping("/create")
	public String showCreatePage(Model model) {
		ProductsDTO dto = new ProductsDTO();
		model.addAttribute("dto",dto);
		return "products/CreateProduct";
	}
	
	@PostMapping("/create")
	public String createProduct(@Valid @ModelAttribute ProductsDTO dto) {
		MultipartFile image = dto.getAnh();
		String FileName=image.getOriginalFilename();
		try {
			String uploadDir="public/images/";
			Path uploadPath = Paths.get(uploadDir);
			if(!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			try(InputStream inputStream = image.getInputStream()){
				Files.copy(inputStream, Paths.get(uploadDir),StandardCopyOption.REPLACE_EXISTING);
			}	
		}catch(Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		
		Product product = new Product();
		product.setTen(dto.getTen());
		product.setGia(dto.getGia());
		product.setChitiet(dto.getChitiet());
		product.setAnh(FileName);
		
		repo.save(product);
		return "redirect:/products";
	}
	
	@GetMapping("/edit")
	public String showEditPage(Model model, @RequestParam int id) {
		try {
			Product product = repo.findById(id).get();
			model.addAttribute("product",product);
			ProductsDTO dto = new ProductsDTO();
			dto.setTen(product.getTen());
			dto.setGia(product.getGia());
			dto.setChitiet(product.getChitiet());
			model.addAttribute("dto", dto);
		}
		catch(Exception ex){
			System.out.println("Exception: " + ex.getMessage());
			return "redirect:/products";
		}
		return"products/EditProduct";
	}
	
	@PostMapping("/edit")
	public String updateProduct(Model model,@RequestParam int id, @Valid @ModelAttribute ProductsDTO dto) {
		try {
			Product product = repo.findById(id).get();
			model.addAttribute("product",product);
			if(!dto.getAnh().isEmpty()) {
				//Xoa anh cu
				String uploadDir = "public/images/";
				Path anhcu = Paths.get(uploadDir + product.getAnh());
				try {
					Files.delete(anhcu);
				}
				catch(Exception ex) {
					System.out.println("Exception: " + ex.getMessage());
				}
				
			//Save anh moi
				MultipartFile image = dto.getAnh();
				String FileName = image.getOriginalFilename();
				try(InputStream inputStream = image.getInputStream()){
					Files.copy(inputStream, Paths.get(uploadDir + FileName),StandardCopyOption.REPLACE_EXISTING);
				}
				product.setAnh(FileName);
			}
			product.setTen(dto.getTen());
			product.setGia(dto.getGia());
			product.setChitiet(dto.getChitiet());
			
			repo.save(product);
		}
		catch(Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		return "redirect:/products"; 
	}
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam int id) {
		try {
			Product product = repo.findById(id).get();
			Path imagePath = Paths.get("public/images/" + product.getAnh());
			try {
				Files.delete(imagePath);
			}
			catch(Exception ex){
				System.out.println("Exception: " + ex.getMessage());
			}
			repo.delete(product);
		}
		catch(Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		return "redirect:/products";
	}
}
