package cetam.projeto02grupo04.services;

import cetam.projeto02grupo04.model.Pagamento;
import cetam.projeto02grupo04.model.StatusPagamento;
import cetam.projeto02grupo04.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StatusPagamentoServices {
    @Autowired
    private PagamentoRepository repository;

    public void atualizarStatus(Long id, StatusPagamento novoStatus) {
        // Busca o pagamento pelo ID
        Pagamento pagamento = repository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado."));

        // Regra simples: Se já foi aprovado, não deixa mudar
        if (pagamento.getStatusPagamento() == StatusPagamento.Aprovado) {
            throw new RuntimeException("Pagamento já aprovado não pode ser alterado.");
        }

        // Atualiza e salva no banco
        pagamento.setStatusPagamento(novoStatus);
        repository.save(pagamento);
    }
}

