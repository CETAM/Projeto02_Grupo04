
package cetam.projeto02grupo04.services;

import cetam.projeto02grupo04.model.Pagamento;
import cetam.projeto02grupo04.model.PagamentoForm;
import cetam.projeto02grupo04.model.Pedido;
import cetam.projeto02grupo04.repository.PagamentoRepository;
import cetam.projeto02grupo04.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoServices {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public void realizarPagamento(PagamentoForm form) {
        Pedido pedido = pedidoRepository.findById(form.getIdPedido())
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado!"));

        Pagamento pagamento = new Pagamento();
        pagamento.setPedido(pedido);
        pagamento.setFormaPagamento(form.getFormaPagamento());
        pagamento.setValorPago(form.getValor());

        pagamentoRepository.save(pagamento);
    }
}