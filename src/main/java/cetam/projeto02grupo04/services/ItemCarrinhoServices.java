package cetam.projeto02grupo04.services;

import cetam.projeto02grupo04.model.ItemCarrinho;
import cetam.projeto02grupo04.repository.ItemCarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCarrinhoServices {

    @Autowired
    private ItemCarrinhoRepository repository;

    public void salvar(ItemCarrinho itemCarrinho) {
        repository.save(itemCarrinho);
    }

    public List<ItemCarrinho> listarTodos() {
        return repository.findAll();
    }

    public ItemCarrinho buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<ItemCarrinho> buscarPorCarrinho(Integer idCarrinho) {
        return repository.findByIdCarrinho(idCarrinho);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}