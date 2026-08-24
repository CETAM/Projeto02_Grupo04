package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.PedidoItem;
import cetam.projeto02grupo04.service.PedidoItemService; // 1. IMPORT ADICIONADO
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/itempedido")
public class PedidoItemController {

    @Autowired
    private PedidoItemService service;

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute PedidoItem pedidoItem) {
        service.salvar(pedidoItem);
        return "redirect:/pedidos/" + PedidoItem.getPedido().getId();
    }
    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id, @RequestParam Long pedidoId) {
        service.deletar(id);
        return "redirect:/pedidos/" + pedidoId;

    }
}