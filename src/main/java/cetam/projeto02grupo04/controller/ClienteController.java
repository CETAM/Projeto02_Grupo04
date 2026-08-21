package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.Pessoa;
import cetam.projeto02grupo04.repository.PessoaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final PessoaRepository pessoaRepository;

    public ClienteController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping
    public List<Pessoa> listarClientes() {
        return pessoaRepository.findByTipoIgnoreCase("Cliente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarCliente(@PathVariable Long id) {
        return pessoaRepository.findById(id)
                .filter(pessoa -> pessoa.getTipo().equalsIgnoreCase("Cliente"))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pessoa cadastrarCliente(@RequestBody Pessoa pessoa) {
        pessoa.setId(null);
        pessoa.setTipo("Cliente");
        return pessoaRepository.save(pessoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarCliente(@PathVariable Long id, @RequestBody Pessoa dados) {
        return pessoaRepository.findById(id)
                .filter(pessoa -> pessoa.getTipo().equalsIgnoreCase("Cliente"))
                .map(pessoa -> {
                    pessoa.setNome(dados.getNome());
                    pessoa.setEmail(dados.getEmail());
                    pessoa.setSenha(dados.getSenha());
                    pessoa.setCpfCnpj(dados.getCpfCnpj());
                    pessoa.setTelefone(dados.getTelefone());
                    return ResponseEntity.ok(pessoaRepository.save(pessoa));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        return pessoaRepository.findById(id)
                .filter(pessoa -> pessoa.getTipo().equalsIgnoreCase("Cliente"))
                .map(pessoa -> {
                    pessoaRepository.delete(pessoa);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
