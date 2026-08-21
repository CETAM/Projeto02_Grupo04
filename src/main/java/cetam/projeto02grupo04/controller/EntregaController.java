package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.Entrega;
import cetam.projeto02grupo04.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    // GET /api/entregas -> lista todas as entregas
    @GetMapping
    public List<Entrega> listarTodas() {
        return entregaService.listarTodas();
    }

    // GET /api/entregas/{id} -> busca uma entrega pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Entrega> buscarPorId(@PathVariable Long id) {
        return entregaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/entregas/rastreio/{codigo} -> busca uma entrega pelo código de rastreio
    @GetMapping("/rastreio/{codigo}")
    public ResponseEntity<Entrega> buscarPorCodigoRastreio(@PathVariable String codigo) {
        return entregaService.buscarPorCodigoRastreio(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/entregas/pessoa/{idPessoa} -> lista entregas de uma pessoa
    @GetMapping("/pessoa/{idPessoa}")
    public List<Entrega> buscarPorPessoa(@PathVariable Long idPessoa) {
        return entregaService.buscarPorPessoa(idPessoa);
    }

    // GET /api/entregas/status/{status} -> lista entregas por status
    @GetMapping("/status/{status}")
    public List<Entrega> buscarPorStatus(@PathVariable String status) {
        return entregaService.buscarPorStatus(status);
    }

    // POST /api/entregas -> cria uma nova entrega
    @PostMapping
    public ResponseEntity<Entrega> criar(@RequestBody Entrega entrega) {
        Entrega salva = entregaService.criar(entrega);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    // PUT /api/entregas/{id} -> atualiza uma entrega existente
    @PutMapping("/{id}")
    public ResponseEntity<Entrega> atualizar(@PathVariable Long id, @RequestBody Entrega dadosAtualizados) {
        return entregaService.atualizar(id, dadosAtualizados)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PATCH /api/entregas/{id}/enviar?codigoRastreio=XYZ -> registra o envio da entrega
    @PatchMapping("/{id}/enviar")
    public ResponseEntity<Entrega> registrarEnvio(@PathVariable Long id, @RequestParam String codigoRastreio) {
        return entregaService.registrarEnvio(id, codigoRastreio)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PATCH /api/entregas/{id}/entregar -> registra a entrega como realizada
    @PatchMapping("/{id}/entregar")
    public ResponseEntity<Entrega> registrarEntregaRealizada(@PathVariable Long id) {
        return entregaService.registrarEntregaRealizada(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/entregas/{id} -> remove uma entrega
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!entregaService.deletar(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
