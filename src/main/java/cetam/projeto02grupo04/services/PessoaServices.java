package cetam.projeto02grupo04.services;

import cetam.projeto02grupo04.model.Pessoa;
import cetam.projeto02grupo04.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServices {

    private final PessoaRepository repository;

    public PessoaServices(PessoaRepository repository) {
        this.repository = repository;
    }

    public List<Pessoa> listar() {
        return repository.findAll();
    }

    public Pessoa buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Pessoa salvar(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}


    

