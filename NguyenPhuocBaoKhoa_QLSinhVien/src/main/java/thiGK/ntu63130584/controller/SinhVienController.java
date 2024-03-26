package thiGK.ntu63130584.controller;
import java.util.List;
import thiGK.ntu63130584.model.SinhVien;
import thiGK.ntu63130584.service.SinhVienService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class SinhVienController {
 @Autowired
    private SinhVienService sinhVienService;

    @GetMapping("/home")
    public String index(Model model) {
        List<SinhVien> List = sinhVienService.layDanhSach();
        
        model.addAttribute("List",List);

        return "index";
    }

    
}
