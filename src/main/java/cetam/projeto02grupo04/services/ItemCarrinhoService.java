package cetam.projeto02grupo04.services;

import cetam.projeto02grupo04.model.ItemCarrinho;
import cetam.projeto02grupo04.repository.ItemCarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Services;

@Service
public class ItemCarrinhoService {

    @Autowired
    private ItemCarrinhoRepository repository;

    public void salvar(ItemCarrinho itemCarrinho) {
        // Aqui você pode colocar regras de negócio futuras (ex: validar quantidade > 0)
        repository.save(itemCarrinho);
    }
}