package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.PedidoItem;
import cetam.projeto02grupo04.services.PedidoItemServices; // 1. IMPORT ADICIONADO
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/itempedido")
public class PedidoItemController {

    @Autowired
    private PedidoItemServices services;

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute PedidoItem pedidoItem) {
        services.salvar(pedidoItem);
        // Usando o objeto "pedidoItem" (minúsculo) em vez da classe "PedidoItem":
        return "redirect:/pedidos/" + pedidoItem.getPedido().getId();
    }
    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id, @RequestParam Long pedidoId) {
        services.deletar(id);
        return "redirect:/pedidos/" + pedidoId;

    }
}