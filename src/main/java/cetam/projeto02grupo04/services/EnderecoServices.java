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
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> buscarPorId(Integer id) {
        return enderecoRepository.findById(id);
    }

    public List<Endereco> buscarPorCep(String cep) {
        return enderecoRepository.findByCep(cep);
    }

    public List<Endereco> buscarPorCidade(String cidade) {
        return enderecoRepository.findByCidade(cidade);
    }

    public Endereco criar(Endereco endereco) {
        if (endereco.getCep() == null || endereco.getCep().trim().isEmpty()) {
            throw new IllegalArgumentException("O CEP é obrigatório.");
        }
        return enderecoRepository.save(endereco);
    }

    public Endereco atualizar(Integer id, Endereco endereco) {
        if (!enderecoRepository.existsById(id)) {
            throw new IllegalArgumentException("Endereço não encontrado para atualização com o ID: " + id);
        }
        endereco.setIdEndereco(id);
        return enderecoRepository.save(endereco);
    }

    public void deletar(Integer id) {
        if (!enderecoRepository.existsById(id)) {
            throw new IllegalArgumentException("Endereço não encontrado com o ID: " + id);
        }
        enderecoRepository.deleteById(id);
    }
}