package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.Pedido;
import cetam.projeto02grupo04.services.PedidoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoServices service;

    // Processa a adição ao carrinho
    @PostMapping("/adicionar")
    public String adicionarAoCarrinho(Pedido pedido) {
        // Se a pessoa veio nula ou não foi preenchida na requisição, remove o objeto para não tentar persistir ID vazia
        if (pedido.getPessoa() != null && pedido.getPessoa().getIdPessoa() == null) {
            pedido.setPessoa(null);
        }

        // Se o endereço veio nulo ou não foi preenchido na requisição, remove o objeto
        if (pedido.getEndereco() != null && pedido.getEndereco().getIdEndereco() == null) {
            pedido.setEndereco(null);
        }

        service.salvar(pedido);
        return "redirect:/pedidos/carrinho";
    }

    // Exibe a página do carrinho e contabiliza os itens
    @GetMapping("/carrinho")
    public String verCarrinho(Model model) {
        var lista = service.listarTodos();
        model.addAttribute("pedidos", lista);
        model.addAttribute("totalItens", lista.size()); // Alimenta a tag th:text do HTML
        return "pedidos/pedidos";
    }

    @GetMapping
    public String listarPedidos(Model model) {
        var lista = service.listarTodos();
        model.addAttribute("pedidos", lista);
        model.addAttribute("totalItens", lista.size());
        return "pedidos/pedidos";
    }
}