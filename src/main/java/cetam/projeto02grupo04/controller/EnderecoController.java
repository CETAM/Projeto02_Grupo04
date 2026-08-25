package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.Endereco;
import cetam.projeto02grupo04.services.EnderecoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoServices enderecoServices;

    @GetMapping
    public ResponseEntity<List<Endereco>> listarTodos() {
        return ResponseEntity.ok(enderecoServices.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        return enderecoServices.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<List<Endereco>> buscarPorCep(@PathVariable String cep) {
        return ResponseEntity.ok(enderecoServices.buscarPorCep(cep));
    }

    @GetMapping("/cidade/{cidade}")
    public ResponseEntity<List<Endereco>> buscarPorCidade(@PathVariable String cidade) {
        return ResponseEntity.ok(enderecoServices.buscarPorCidade(cidade));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Endereco endereco) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(enderecoServices.criar(endereco));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody Endereco endereco) {
        try {
            endereco.setId(id);
            return ResponseEntity.ok(enderecoServices.atualizar(id, endereco));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        try {
            enderecoServices.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}