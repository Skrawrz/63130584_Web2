package thiGK.ntu63130584.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
	 @GetMapping({"/", "/home"})
	    public String index(Model model) {
	        
	        return "index";
	    }

}
