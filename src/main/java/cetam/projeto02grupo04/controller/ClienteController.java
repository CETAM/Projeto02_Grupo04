package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.Cliente;
import cetam.projeto02grupo04.repository.ClienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    // A página começa em 0 e mostra 5 clientes por página.
    @GetMapping
    public String carregarClientes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            Model model) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by("nome").ascending()
        );

        Page<Cliente> clientes = clienteRepository.findAll(pageable);

        model.addAttribute("clientes", clientes);
        model.addAttribute("cliente", new Cliente());

        return "clientes/clientes";
    }

    // Cadastra um novo cliente.
    @PostMapping("/salvar")
    public String salvarCliente(@ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }

    // Exclui um cliente pelo ID.
    @GetMapping("/excluir/{id}")
    public String excluirCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return "redirect:/clientes";
    }
}
