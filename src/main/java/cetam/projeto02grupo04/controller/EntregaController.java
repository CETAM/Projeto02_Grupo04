package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.Entrega;
import cetam.projeto02grupo04.services.EntregaServices; // <-- FALTAVA ESTE IMPORT
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entregas")
public class EntregaController {

    @Autowired
    private EntregaServices entregaServices;

    @GetMapping
    public ResponseEntity<List<Entrega>> listarTodas() {
        return ResponseEntity.ok(entregaServices.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrega> buscarPorId(@PathVariable Integer id) {
        return entregaServices.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/rastreio/{codigo}")
    public ResponseEntity<Entrega> buscarPorRastreio(@PathVariable String codigo) {
        return entregaServices.buscarPorCodigoRastreio(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pessoa/{idPessoa}")
    public ResponseEntity<List<Entrega>> buscarPorPessoa(@PathVariable Integer idPessoa) {
        return ResponseEntity.ok(entregaServices.buscarPorPessoa(idPessoa));
    }

    @PostMapping
    public ResponseEntity<Entrega> criar(@RequestBody Entrega entrega) {
        Entrega novaEntrega = entregaServices.salvar(entrega);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEntrega);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Entrega> atualizarStatus(
            @PathVariable Integer id,
            @RequestParam String novoStatus) {
        try {
            Entrega entregaAtualizada = entregaServices.atualizarStatus(id, novoStatus);
            return ResponseEntity.ok(entregaAtualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        entregaServices.deletar(id);
        return ResponseEntity.noContent().build();
    }
}