package com.dodunghoctap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoDungHocTapController {
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/available")
	public String getAll() {
		return "bookList";
	}
	@GetMapping("/them")
	public String ThemSP() {
		return "ThemSP";
	}
}
