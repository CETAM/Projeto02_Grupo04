package cetam.projeto02grupo04.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Table(name = "entrega")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrega")
    private Long id;

    @Column(name = "id_pessoa", nullable = false)
    private Long idPessoa;

    @Column(name = "id_endereco", nullable = false)
    private Long idEndereco;

    @Column(name = "data_envio")
    private LocalDateTime dataEnvio;

    @Column(name = "data_entrega_prevista")
    private LocalDate dataEntregaPrevista;

    @Column(name = "data_entrega_realizada")
    private LocalDateTime dataEntregaRealizada;

    @Column(name = "status_entrega")
    private String statusEntrega = "Em Processamento";

    @Column(name = "codigo_rastreio")
    private String codigoRastreio;

    // Construtores
    public Entrega() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdPessoa() { return idPessoa; }
    public void setIdPessoa(Long idPessoa) { this.idPessoa = idPessoa; }

    public Long getIdEndereco() { return idEndereco; }
    public void setIdEndereco(Long idEndereco) { this.idEndereco = idEndereco; }

    public LocalDateTime getDataEnvio() { return dataEnvio; }
    public void setDataEnvio(LocalDateTime dataEnvio) { this.dataEnvio = dataEnvio; }

    public LocalDate getDataEntregaPrevista() { return dataEntregaPrevista; }
    public void setDataEntregaPrevista(LocalDate dataEntregaPrevista) { this.dataEntregaPrevista = dataEntregaPrevista; }

    public LocalDateTime getDataEntregaRealizada() { return dataEntregaRealizada; }
    public void setDataEntregaRealizada(LocalDateTime dataEntregaRealizada) { this.dataEntregaRealizada = dataEntregaRealizada; }

    public String getStatusEntrega() { return statusEntrega; }
    public void setStatusEntrega(String statusEntrega) { this.statusEntrega = statusEntrega; }

    public String getCodigoRastreio() { return codigoRastreio; }
    public void setCodigoRastreio(String codigoRastreio) { this.codigoRastreio = codigoRastreio; }
}