package cetam.projeto02grupo04.services;

import cetam.projeto02grupo04.model.Pagamento;
import cetam.projeto02grupo04.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PagamentoServices {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento salvar(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public Optional<Pagamento> buscarPorIdPedido(Integer idPedido) {
        return pagamentoRepository.findByIdPedido(idPedido);
    }
}