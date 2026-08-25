package cetam.projeto02grupo04.services;

import cetam.projeto02grupo04.model.Produto;
import cetam.projeto02grupo04.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("all")
public class ProdutoServices {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Optional<Produto> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<Produto> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Produto> buscarPorCategoria(Integer idCategoria) {
        return repository.findByIdCategoria(idCategoria);
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public boolean naoExistePorId(Integer id) {
        return !repository.existsById(id);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}