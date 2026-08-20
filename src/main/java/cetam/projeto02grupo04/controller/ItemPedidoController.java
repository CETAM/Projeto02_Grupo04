package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.ItemPedido;
import cetam.projeto02grupo04.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/itempedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService service;

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute ItemPedido itemPedido) {
        service.salvar(itemPedido);
        return "redirect:/pedidos/" + itemPedido.getPedido().getId();
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id, @RequestParam Long pedidoId) {
        service.deletar(id);
        return "redirect:/pedidos/" + pedidoId;
    }
}