package cetam.projeto02grupo04.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long id;

    @Column(name = "id_pessoa", nullable = false)
    private Long idPessoa;

    @Column(name = "id_endereco", nullable = false)
    private Long idEndereco;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    @Column(name = "status_pedido")
    private String statusPedido = "Pendente";

    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;

    // Construtores
    public Pedido() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdPessoa() { return idPessoa; }
    public void setIdPessoa(Long idPessoa) { this.idPessoa = idPessoa; }

    public Long getIdEndereco() { return idEndereco; }
    public void setIdEndereco(Long idEndereco) { this.idEndereco = idEndereco; }

    public LocalDateTime getDataPedido() { return dataPedido; }
    public void setDataPedido(LocalDateTime dataPedido) { this.dataPedido = dataPedido; }

    public String getStatusPedido() { return statusPedido; }
    public void setStatusPedido(String statusPedido) { this.statusPedido = statusPedido; }

    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }
}