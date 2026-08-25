package cetam.projeto02grupo04.services;

import cetam.projeto02grupo04.model.Entrega;
import cetam.projeto02grupo04.repository.EntregaRepository;
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

    // Correção: Parâmetro Integer alterado para Long
    public Optional<Entrega> buscarPorId(Long id) {
        return entregaRepository.findById(id);
    }

    public Optional<Entrega> buscarPorCodigoRastreio(String codigoRastreio) {
        return entregaRepository.findByCodigoRastreio(codigoRastreio);
    }

    // Correção: Parâmetro Integer alterado para Long e chamada ajustada para findByIdPessoa
    public List<Entrega> buscarPorPessoa(Long idPessoa) {
        return entregaRepository.findByIdPessoa(idPessoa);
    }

    public List<Entrega> buscarPorStatus(String status) {
        return entregaRepository.findByStatusEntrega(status);
    }

    public Entrega criar(Entrega entrega) {
        return entregaRepository.save(entrega);
    }

    // Correção: Parâmetro Integer alterado para Long
    public Entrega atualizar(Long id, Entrega entregaAtualizada) {
        Entrega entrega = entregaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrega não encontrada"));
        entrega.setStatusEntrega(entregaAtualizada.getStatusEntrega());
        entrega.setCodigoRastreio(entregaAtualizada.getCodigoRastreio());
        return entregaRepository.save(entrega);
    }

    // Correção: Parâmetro Integer alterado para Long
    public Entrega registrarEnvio(Long id) {
        Entrega entrega = entregaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrega não encontrada"));
        entrega.setDataEnvio(LocalDateTime.now());
        entrega.setStatusEntrega("Enviado");
        return entregaRepository.save(entrega);
    }

    // Correção: Parâmetro Integer alterado para Long
    public Entrega registrarEntregaRealizada(Integer id) {
        Entrega entrega = entregaRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Entrega não encontrada"));
        entrega.setDataEntregaRealizada(LocalDateTime.now());
        entrega.setStatusEntrega("Entregue");
        return entregaRepository.save(entrega);
    }

    // Correção: Parâmetro Integer alterado para Long
    public void deletar(Long id) {
        entregaRepository.deleteById(id);
    }
}