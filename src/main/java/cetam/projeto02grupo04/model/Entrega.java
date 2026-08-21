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

    @ManyToOne
    @JoinColumn(name = "id_pessoa", nullable = false)
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "id_endereco", nullable = false)
    private String idEndereco;

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

    // Construtor vazio
    public Entrega() {
    }

    public Entrega(Long idEntrega, Pessoa pessoa, String idEndereco, Date dataEnvio, Date dataEntregaPrevista, Date dataEntregaRealizada, String statusEntrega, String codigoRastreio) {
        this.idEntrega = idEntrega;
        this.pessoa = pessoa;
        this.idEndereco = idEndereco;
        this.dataEnvio = dataEnvio;
        this.dataEntregaPrevista = dataEntregaPrevista;
        this.dataEntregaRealizada = dataEntregaRealizada;
        this.statusEntrega = statusEntrega;
        this.codigoRastreio = codigoRastreio;
    }

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

    public String getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(String idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Date getDataEntregaPrevista() {
        return dataEntregaPrevista;
    }

    public void setDataEntregaPrevista(Date dataEntregaPrevista) {
        this.dataEntregaPrevista = dataEntregaPrevista;
    }

    public Date getDataEntregaRealizada() {
        return dataEntregaRealizada;
    }

    public void setDataEntregaRealizada(Date dataEntregaRealizada) {
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