package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.Pessoa;
import cetam.projeto02grupo04.repository.PessoaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
@CrossOrigin(origins = "*")
public class PessoaController {

    private final PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    // =====================================================
    // 1. LISTAR TODAS AS PESSOAS
    // =====================================================

    @GetMapping
    public List<Pessoa> listarTodas() {
        return pessoaRepository.findAll();
    }


    // =====================================================
    // 2. LISTAR PESSOAS POR TIPO
    // Cliente, Fornecedor ou Funcionario
    // =====================================================

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Pessoa>> listarPorTipo(
            @PathVariable String tipo) {

        if (!tipoValido(tipo)) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(
                pessoaRepository.findByTipoIgnoreCase(tipoNormalizado(tipo))
        );
    }


    // =====================================================
    // 3. BUSCAR PESSOA POR ID
    // =====================================================

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(
            @PathVariable Long id) {

        return pessoaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    // =====================================================
    // 4. CADASTRAR NOVA PESSOA
    // =====================================================

    @PostMapping
    public ResponseEntity<?> cadastrar(
            @RequestBody Pessoa pessoa) {

        if (!tipoValido(pessoa.getTipo())) {
            return ResponseEntity
                    .badRequest()
                    .body("Tipo de pessoa inválido. Use: Cliente, Fornecedor ou Funcionario.");
        }

        pessoa.setId(null);
        pessoa.setTipo(tipoNormalizado(pessoa.getTipo()));

        Pessoa novaPessoa = pessoaRepository.save(pessoa);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(novaPessoa);
    }


    // =====================================================
    // 5. ATUALIZAR PESSOA
    // =====================================================

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody Pessoa dados) {

        if (!tipoValido(dados.getTipo())) {
            return ResponseEntity
                    .badRequest()
                    .body("Tipo de pessoa inválido. Use: Cliente, Fornecedor ou Funcionario.");
        }

        return pessoaRepository.findById(id)
                .map(pessoa -> {

                    pessoa.setTipo(tipoNormalizado(dados.getTipo()));
                    pessoa.setNome(dados.getNome());
                    pessoa.setEmail(dados.getEmail());
                    pessoa.setSenha(dados.getSenha());
                    pessoa.setCpfCnpj(dados.getCpfCnpj());
                    pessoa.setTelefone(dados.getTelefone());

                    Pessoa pessoaAtualizada =
                            pessoaRepository.save(pessoa);

                    return ResponseEntity.ok(pessoaAtualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    // =====================================================
    // 6. DELETAR PESSOA
    // =====================================================

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {

        if (!pessoaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        pessoaRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


    // =====================================================
    // MÉTODO PARA VALIDAR O TIPO DE PESSOA
    // =====================================================

    private boolean tipoValido(String tipo) {

        if (tipo == null) {
            return false;
        }

        return tipo.equalsIgnoreCase("Cliente")
                || tipo.equalsIgnoreCase("Fornecedor")
                || tipo.equalsIgnoreCase("Funcionario")
                || tipo.equalsIgnoreCase("Funcionário");
    }


    // =====================================================
    // MÉTODO PARA PADRONIZAR O TIPO
    // =====================================================

    private String tipoNormalizado(String tipo) {

        if (tipo.equalsIgnoreCase("Cliente")) {
            return "Cliente";
        }

        if (tipo.equalsIgnoreCase("Fornecedor")) {
            return "Fornecedor";
        }

        if (tipo.equalsIgnoreCase("Funcionario")
                || tipo.equalsIgnoreCase("Funcionário")) {
            return "Funcionario";
        }

        return tipo;
    }
}