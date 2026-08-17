package cetam.projeto02grupo04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    // Acessa a página de gerenciamento de clientes em http://localhost:8080/clientes
    @GetMapping
    public String carregarClientes() {
        return "clientes/clientes";
    }
}
