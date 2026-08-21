package cetam.projeto02grupo04.model;

import jakarta.persistence.*;

@Entity
@Table(name = "item_carrinho")
public class ItemCarrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItemCarrinho;

    @Column(name = "id_carrinho")
    private Long idCarrinho;

    @Column(name = "id_produto")
    private Long idProduto;

    private Integer quantidade;

    // Getters e Setters
    public Long getIdItemCarrinho() {
        return idItemCarrinho;
    }

    public void setIdItemCarrinho(Long idItemCarrinho) {
        this.idItemCarrinho = idItemCarrinho;
    }

    public Long getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Long idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}