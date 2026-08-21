package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.ItemPedido;
import cetam.projeto02grupo04.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/itens-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService service;

    @PostMapping("/salvar")
    public String salvar(ItemPedido itemPedido) {
        service.salvar(itemPedido);
        return "redirect:/itens-pedido";
    }
}