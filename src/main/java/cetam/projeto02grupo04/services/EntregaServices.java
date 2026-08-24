package cetam.projeto02grupo04.services;

import cetam.projeto02grupo04.model.Entrega;
import cetam.projeto02grupo04.repository.EntregaRepository; // <-- FALTAVA ESTE IMPORT
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EntregaServices {

    @Autowired
    private EntregaRepository entregaRepository;

    public List<Entrega> listarTodas() {
        return entregaRepository.findAll();
    }

    public Optional<Entrega> buscarPorId(Integer id) {
        return entregaRepository.findById(id);
    }

    public Optional<Entrega> buscarPorCodigoRastreio(String codigo) {
        return entregaRepository.findByCodigoRastreio(codigo);
    }

    public List<Entrega> buscarPorPessoa(Integer idPessoa) {
        return entregaRepository.findByPessoaIdPessoa(idPessoa);
    }

    public Entrega salvar(Entrega entrega) {
        return entregaRepository.save(entrega);
    }

    public Entrega atualizarStatus(Integer id, String novoStatus) {
        Entrega entrega = entregaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrega não encontrada com ID: " + id));

        entrega.setStatusEntrega(novoStatus);

        if ("Entregue".equalsIgnoreCase(novoStatus)) {
            entrega.setDataEntregaRealizada(LocalDateTime.now());
        }

        return entregaRepository.save(entrega);
    }

    public void deletar(Integer id) {
        entregaRepository.deleteById(id);
    }
}