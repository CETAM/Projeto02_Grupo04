package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.Produto;
import cetam.projeto02grupo04.services.ProdutoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@SuppressWarnings("all")
public class ProdutoController {

    @Autowired
    private ProdutoServices service;

    @GetMapping
    public List<Produto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/busca")
    public ModelAndView buscarPorNome(@RequestParam("nome") String nome) {
        // Muda de "detalhes-produto" para "index"
        ModelAndView mv = new ModelAndView("index");

        List<Produto> resultado = service.buscarPorNome(nome);
        mv.addObject("produtos", resultado);
        mv.addObject("termoBusca", nome);

        return mv;
    }
    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
        Produto novoProduto = service.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Integer id, @RequestBody Produto produtoDetalhes) {
        if (service.naoExistePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        produtoDetalhes.setId(id);
        Produto atualizado = service.salvar(produtoDetalhes);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (service.naoExistePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}