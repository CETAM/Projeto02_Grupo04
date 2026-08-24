package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.Endereco;
import cetam.projeto02grupo04.services.EnderecoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoServices service;

    @GetMapping
    public List<Endereco> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Endereco cadastrar(@RequestBody Endereco endereco) {
        return service.salvar(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizar(@PathVariable Long id, @RequestBody Endereco enderecoDetalhes) {
        if (!service.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        enderecoDetalhes.setId(id);
        Endereco atualizado = service.salvar(enderecoDetalhes);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!service.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
