package cetam.projeto02grupo04.repository;

import cetam.projeto02grupo04.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.ScopedValue;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {


}
