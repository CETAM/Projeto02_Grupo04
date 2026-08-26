package cetam.projeto02grupo04.model;

import jakarta.persistence.*;

@Entity
@Table(name = "item_carrinho")
public class ItemCarrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_carrinho")
    private Integer idItemCarrinho;

    @Column(name = "id_carrinho", nullable = false)
    private Integer idCarrinho;

    @Column(name = "id_produto", nullable = false)
    private Integer idProduto;

    @Column(nullable = false)
    private Integer quantidade;

    // Getters e Setters
    public Integer getIdItemCarrinho() {
        return idItemCarrinho;
    }

    public void setIdItemCarrinho(Integer idItemCarrinho) {
        this.idItemCarrinho = idItemCarrinho;
    }

    public Integer getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Integer idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}