package cetam.projeto02grupo04.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "entrega")
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrega")
    private Long idEntrega;

    // Ajuste o import/pacote de Pessoa e Endereco caso sejam diferentes no seu projeto
    @ManyToOne
    @JoinColumn(name = "id_pessoa", nullable = false)
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "id_endereco", nullable = false)
    private String endereco;

    @Column(name = "data_envio")
    private Date dataEnvio;

    @Column(name = "data_entrega_prevista")
    private Date dataEntregaPrevista;

    @Column(name = "data_entrega_realizada")
    private Date dataEntregaRealizada;

    @Column(name = "status_entrega", length = 30)
    private String statusEntrega = "Em Processamento";

    @Column(name = "codigo_rastreio", length = 50)
    private String codigoRastreio;

    public Entrega() {
    }

    public Entrega(Long idEntrega, Pessoa pessoa, String endereco, Date dataEnvio, Date dataEntregaPrevista, Date dataEntregaRealizada, String statusEntrega, String codigoRastreio) {
        this.idEntrega = idEntrega;
        this.pessoa = pessoa;
        this.endereco = endereco;
        this.dataEnvio = dataEnvio;
        this.dataEntregaPrevista = dataEntregaPrevista;
        this.dataEntregaPrevista = dataEntregaPrevista;
        this.dataEntregaRealizada = dataEntregaRealizada;
        this.statusEntrega = statusEntrega;
        this.codigoRastreio = codigoRastreio;
    }

    // ---------- Getters e Setters ----------

    public Long getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(Long idEntrega) {
        this.idEntrega = idEntrega;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public LocalDate getDataEntregaPrevista() {
        return dataEntregaPrevista;
    }

    public void setDataEntregaPrevista(LocalDate dataEntregaPrevista) {
        this.dataEntregaPrevista = dataEntregaPrevista;
    }

    public LocalDateTime getDataEntregaRealizada() {
        return dataEntregaRealizada;
    }

    public void setDataEntregaRealizada(LocalDateTime dataEntregaRealizada) {
        this.dataEntregaRealizada = dataEntregaRealizada;
    }

    public String getStatusEntrega() {
        return statusEntrega;
    }

    public void setStatusEntrega(String statusEntrega) {
        this.statusEntrega = statusEntrega;
    }

    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public void setCodigoRastreio(String codigoRastreio) {
        this.codigoRastreio = codigoRastreio;
    }

}
