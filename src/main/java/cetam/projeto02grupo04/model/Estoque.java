package cetam.projeto02grupo04.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estoque")
    private Integer idEstoque;

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    @Column(name = "quant_entrada")
    private Double quantEntrada;

    @Column(name = "quant_saida")
    private Double quantSaida;

    @Column(name = "quant_minima")
    private Double quantMinima;

    // Getters e Setters
    public Integer getIdEstoque() { return idEstoque; }
    public void setIdEstoque(Integer idEstoque) { this.idEstoque = idEstoque; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public Double getQuantEntrada() { return quantEntrada; }
    public void setQuantEntrada(Double quantEntrada) { this.quantEntrada = quantEntrada; }

    public Double getQuantSaida() { return quantSaida; }
    public void setQuantSaida(Double quantSaida) { this.quantSaida = quantSaida; }

    public Double getQuantMinima() { return quantMinima; }
    public void setQuantMinima(Double quantMinima) { this.quantMinima = quantMinima; }
} 
