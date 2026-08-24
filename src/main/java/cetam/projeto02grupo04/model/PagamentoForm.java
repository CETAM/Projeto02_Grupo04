package cetam.projeto02grupo04.model;

import java.math.BigDecimal;

public class PagamentoForm {
    private Long idPedido;
    private FormadePagamento FormadePagamento;
    private BigDecimal valor;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public FormadePagamento getFormadePagamento() {
        return FormadePagamento;
    }
    public void setFormaPagamento(FormadePagamento formaPagamento) {
        this.FormadePagamento = formaPagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}