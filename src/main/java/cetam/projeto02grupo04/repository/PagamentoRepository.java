package cetam.projeto02grupo04.repository;

import cetam.projeto02grupo04.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
    Optional<Pagamento> findByIdPedido(Integer idPedido);
}