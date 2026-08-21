package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.Pedido;
import cetam.projeto02grupo04.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    // Listar todos os pedidos na página
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pedidos", service.listarTodos());
        return "pedidos/lista"; // Retorna o caminho da sua página HTML/Thymeleaf
    }

    // Salvar ou atualizar o pedido
    @PostMapping("/salvar")
    public String salvar(Pedido pedido) {
        service.salvar(pedido);
        return "redirect:/pedidos";
    }

    // Excluir pedido
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/pedidos";
    }
}