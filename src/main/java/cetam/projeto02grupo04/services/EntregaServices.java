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
    private EntregaRepository repository;

    public List<Entrega> listarTodas() {
        return repository.findAll();
    }

    public Optional<Entrega> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Optional<Entrega> buscarPorCodigoRastreio(String codigo) {
        // Exige que o método exist no Repository, ou pode ser ajustado conforme a sua regra
        return repository.findAll().stream()
                .filter(e -> codigo.equals(e.getCodigoRastreio()))
                .findFirst();
    }

    public List<Entrega> buscarPorPessoa(Integer idPessoa) {
        return repository.findAll().stream()
                .filter(e -> e.getPessoa() != null && idPessoa.equals(e.getPessoa().getId()))
                .toList();
    }

    public List<Entrega> buscarPorStatus(String status) {
        return repository.findAll().stream()
                .filter(e -> status.equalsIgnoreCase(e.getStatusEntrega()))
                .toList();
    }

    public Entrega salvar(Entrega entrega) {
        if (entrega.getPessoa() == null) {
            throw new IllegalArgumentException("A pessoa deve ser informada.");
        }
        if (entrega.getEndereco() == null) {
            throw new IllegalArgumentException("O endereço deve ser informado.");
        }
        if (entrega.getStatusEntrega() == null || entrega.getStatusEntrega().isBlank()) {
            entrega.setStatusEntrega("Em Processamento");
        }
        return repository.save(entrega);
    }

    public Entrega criar(Entrega entrega) {
        return salvar(entrega);
    }

    public Entrega atualizar(Integer id, Entrega entregaAtualizada) {
        return repository.findById(id).map(entrega -> {
            entrega.setPessoa(entregaAtualizada.getPessoa());
            entrega.setEndereco(entregaAtualizada.getEndereco());
            entrega.setStatusEntrega(entregaAtualizada.getStatusEntrega());
            entrega.setCodigoRastreio(entregaAtualizada.getCodigoRastreio());
            entrega.setDataEnvio(entregaAtualizada.getDataEnvio());
            entrega.setDataEntregaPrevista(entregaAtualizada.getDataEntregaPrevista());
            entrega.setDataEntregaRealizada(entregaAtualizada.getDataEntregaRealizada());
            return repository.save(entrega);
        }).orElseThrow(() -> new IllegalArgumentException("Entrega não encontrada com ID: " + id));
    }

    public Entrega registrarEnvio(Integer id, String codigoRastreio) {
        return repository.findById(id).map(entrega -> {
            entrega.setCodigoRastreio(codigoRastreio);
            entrega.setStatusEntrega("Enviado");
            entrega.setDataEnvio(LocalDateTime.now());
            return repository.save(entrega);
        }).orElseThrow(() -> new IllegalArgumentException("Entrega não encontrada com ID: " + id));
    }

    public Entrega registrarEntregaRealizada(Integer id) {
        return repository.findById(id).map(entrega -> {
            entrega.setStatusEntrega("Entregue");
            entrega.setDataEntregaRealizada(LocalDateTime.now());
            return repository.save(entrega);
        }).orElseThrow(() -> new IllegalArgumentException("Entrega não encontrada com ID: " + id));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}