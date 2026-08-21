package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.ItemPedido;
import cetam.projeto02grupo04.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/itens-pedido")
=======
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/itempedido")
>>>>>>> 09df01d9a67ed011eaa00f07b23fbb59862fc745
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService service;

    @PostMapping("/salvar")
<<<<<<< HEAD
    public String salvar(ItemPedido itemPedido) {
        service.salvar(itemPedido);
        return "redirect:/itens-pedido";
=======
    public String salvar(@ModelAttribute ItemPedido itemPedido) {
        service.salvar(itemPedido);
        return "redirect:/pedidos/" + itemPedido.getPedido().getId();
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id, @RequestParam Long pedidoId) {
        service.deletar(id);
        return "redirect:/pedidos/" + pedidoId;
>>>>>>> 09df01d9a67ed011eaa00f07b23fbb59862fc745
    }
}