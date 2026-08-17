
package cetam.projeto02grupo04.repository;

import cetam.projeto02grupo04.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}