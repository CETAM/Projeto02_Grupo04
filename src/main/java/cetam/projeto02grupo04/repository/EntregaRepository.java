package cetam.projeto02grupo04.repository;

import cetam.projeto02grupo04.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Integer> {

    Optional<Entrega> findByCodigoRastreio(String codigoRastreio);

    List<Entrega> findByPessoaIdPessoa(Integer idPessoa);

    List<Entrega> findByStatusEntrega(String statusEntrega);
}