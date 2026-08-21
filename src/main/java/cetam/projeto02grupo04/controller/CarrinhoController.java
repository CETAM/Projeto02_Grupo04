package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.Carrinho;
import cetam.projeto02grupo04.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carrinhos")
public class CarrinhoController {

    @Autowired
    private CarrinhoRepository repository;

    @PostMapping("/salvar")
    public String salvar(Carrinho carrinho) {
        repository.save(carrinho);
        return "redirect:/carrinhos";
    }
}
