
package cetam.projeto02grupo04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suaempresa.projeto.model.Estoque;
import com.suaempresa.projeto.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    // Listar todos os registros de estoque
    @GetMapping
    public List<Estoque> listarTodos() {
        return estoqueRepository.findAll();
    }

    // Buscar estoque por ID
    @GetMapping("/{id}")
    public ResponseEntity<Estoque> buscarPorId(@PathVariable Integer id) {
        return estoqueRepository.findById(id)
                .map(estoque -> ResponseEntity.ok().body(estoque))
                .orElse(ResponseEntity.notFound().build());
    }

    // Criar novo registro de estoque
    @PostMapping
    public ResponseEntity<Estoque> criar(@RequestBody Estoque estoque) {
        Estoque novoEstoque = estoqueRepository.save(estoque);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEstoque);
    }

    // Atualizar estoque existente
    @PutMapping("/{id}")
    public ResponseEntity<Estoque> atualizar(@PathVariable Integer id, @RequestBody Estoque estoqueAtualizado) {
        return estoqueRepository.findById(id)
                .map(estoque -> {
                    estoque.setProduto(estoqueAtualizado.getProduto());
                    estoque.setQuantEntrada(estoqueAtualizado.getQuantEntrada());
                    estoque.setQuantSaida(estoqueAtualizado.getQuantSaida());
                    estoque.setQuantMinima(estoqueAtualizado.getQuantMinima());
                    Estoque atualizado = estoqueRepository.save(estoque);
                    return ResponseEntity.ok().body(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar registro de estoque
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        return estoqueRepository.findById(id)
                .map(estoque -> {
                    estoqueRepository.delete(estoque);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
