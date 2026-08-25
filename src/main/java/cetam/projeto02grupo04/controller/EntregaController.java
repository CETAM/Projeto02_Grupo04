package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.Entrega;
import cetam.projeto02grupo04.services.EntregaServices;
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
        return entregaServices.buscarPorId(Long.valueOf(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/rastreio/{codigo}")
    public ResponseEntity<Entrega> buscarPorCodigoRastreio(@PathVariable String codigo) {
        return entregaServices.buscarPorCodigoRastreio(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pessoa/{idPessoa}")
    public ResponseEntity<List<Entrega>> buscarPorPessoa(@PathVariable Integer idPessoa) {
        return ResponseEntity.ok(entregaServices.buscarPorPessoa(Long.valueOf(idPessoa)));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Entrega>> buscarPorStatus(@PathVariable String status) {
        return ResponseEntity.ok(entregaServices.buscarPorStatus(status));
    }

    @PostMapping
    public ResponseEntity<Entrega> criar(@RequestBody Entrega entrega) {
        Entrega novaEntrega = entregaServices.criar(entrega);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEntrega);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrega> atualizar(@PathVariable Integer id, @RequestBody Entrega entrega) {
        try {
            return ResponseEntity.ok(entregaServices.atualizar(Long.valueOf(id), entrega));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/envio")
    public ResponseEntity<Entrega> registrarEnvio(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(entregaServices.registrarEnvio(Long.valueOf(id)));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/entregue")
    public ResponseEntity<Entrega> registrarEntregaRealizada(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(entregaServices.registrarEntregaRealizada(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        entregaServices.deletar(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}