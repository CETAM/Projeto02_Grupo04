package cetam.projeto02grupo04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @GetMapping
    public String listarCategorias() {
        return "categorias/categorias";
    }
}