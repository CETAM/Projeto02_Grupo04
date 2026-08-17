package cetam.projeto02grupo04.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantidadeAtual;
    private Integer quantidadeMinima;
    private String localizacao; // Ex: Prateleira A, Depósito 2

    public Estoque() {}

    public Estoque(Integer quantidadeAtual, Integer quantidadeMinima, String localizacao) {
        this.quantidadeAtual = quantidadeAtual;
        this.quantidadeMinima = quantidadeMinima;
        this.localizacao = localizacao;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getQuantidadeAtual() { return quantidadeAtual; }
    public void setQuantidadeAtual(Integer quantidadeAtual) { this.quantidadeAtual = quantidadeAtual; }

    public Integer getQuantidadeMinima() { return quantidadeMinima; }
    public void setQuantidadeMinima(Integer quantidadeMinima) { this.quantidadeMinima = quantidadeMinima; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }
}
