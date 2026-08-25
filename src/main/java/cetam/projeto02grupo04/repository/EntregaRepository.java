package cetam.projeto02grupo04.repository;

import cetam.projeto02grupo04.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Integer> {

    // Busca todas as entregas de uma pessoa
    List<Entrega> findByPessoa_IdPessoa(Long idPessoa);

    // Busca uma entrega pelo código de rastreio
    Optional<Entrega> findByCodigoRastreio(String codigoRastreio);

    // Busca entregas por status (ex: "Em Processamento", "Enviado", "Entregue")
    List<Entrega> findByStatusEntrega(String statusEntrega);
}