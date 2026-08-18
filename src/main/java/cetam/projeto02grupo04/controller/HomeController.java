package cetam.projeto02grupo04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/templates"})
    public String index() {
        return "produtos/dashboard";// Sem a extensão .html
    }
}