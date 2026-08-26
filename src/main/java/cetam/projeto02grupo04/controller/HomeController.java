package cetam.projeto02grupo04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Abre o index.html quando acessar http://localhost:8080/ ou http://localhost:8080/index
    /*
    //@GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }
    */
    // Abre o dashboard.html quando acessar http://localhost:8080/dashboard
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}