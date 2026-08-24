package cetam.projeto02grupo04.services;

import cetam.projeto02grupo04.model.Endereco;
import cetam.projeto02grupo04.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServices {

    @Autowired
    private EnderecoRepository repository;

    public List<Endereco> listarTodos() {
        return repository.findAll();
    }

    public Optional<Endereco> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<Endereco> buscarPorPessoa(Long idPessoa) {
        return repository.findByIdPessoa(idPessoa);
    }

    public Endereco salvar(Endereco endereco) {
        return repository.save(endereco);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public boolean existePorId(Long id) {
        return repository.existsById(id);
    }
}