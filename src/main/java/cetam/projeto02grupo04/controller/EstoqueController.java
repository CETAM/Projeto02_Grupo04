
package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.Estoque;
import cetam.projeto02grupo04.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    private final EstoqueRepository repository;

    public EstoqueController(EstoqueRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Estoque> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Estoque buscarPorId(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Estoque salvar(@RequestBody Estoque estoque) {
        return repository.save(estoque);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
