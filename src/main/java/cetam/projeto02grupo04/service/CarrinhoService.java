package cetam.projeto02grupo04.service;

import cetam.projeto02grupo04.model.Carrinho;
import cetam.projeto02grupo04.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository repository;

    public void salvar(Carrinho carrinho) {
        repository.save(carrinho);
    }
}