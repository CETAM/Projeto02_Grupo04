
package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.Entrega;
import cetam.projeto02grupo04.services.EntregaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaServices entregaServices;

    @GetMapping
    public ResponseEntity<List<Entrega>> listarTodas() {
        return ResponseEntity.ok(entregaServices.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        return entregaServices.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<?> buscarPorCodigoRastreio(@PathVariable String codigo) {
        return entregaServices.buscarPorCodigoRastreio(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pessoa/{idPessoa}")
    public ResponseEntity<List<Entrega>> buscarPorPessoa(@PathVariable Integer idPessoa) {
        return ResponseEntity.ok(entregaServices.buscarPorPessoa(idPessoa));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Entrega>> buscarPorStatus(@PathVariable String status) {
        return ResponseEntity.ok(entregaServices.buscarPorStatus(status));
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Entrega entrega) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(entregaServices.criar(entrega));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody Entrega entrega) {
        try {
            return ResponseEntity.ok(entregaServices.atualizar(id, entrega));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}/registrar-envio")
    public ResponseEntity<?> registrarEnvio(@PathVariable Integer id, @RequestParam String codigoRastreio) {
        try {
            return ResponseEntity.ok(entregaServices.registrarEnvio(id, codigoRastreio));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}/registrar-entrega")
    public ResponseEntity<?> registrarEntregaRealizada(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(entregaServices.registrarEntregaRealizada(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        entregaServices.deletar(id);
        return ResponseEntity.noContent().build();
    }
}