package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.Pessoa;
import cetam.projeto02grupo04.services.PessoaServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaServices services;

    public PessoaController(PessoaServices services) {
        this.services = services;
    }

    @GetMapping("/tipo/{tipoPessoa}")
    public List<Pessoa> buscarPorTipo(@PathVariable String tipoPessoa) {
        return services.buscarPorTipo(tipoPessoa);
    }
    @GetMapping("/{id}")
    public Pessoa buscarPorId(@PathVariable Integer id) {
        return services.buscarPorId(id);
    }

    @PostMapping
    public Pessoa salvar(@RequestBody Pessoa pessoa) {
        return services.salvar(pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        services.deletar(id);
    }
}
