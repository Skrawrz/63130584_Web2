package vn.skrawrz.khoa.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String trangChu(ModelMap model) {
		model.addAttribute("tb","Hello");
		return "index";
	}

}
