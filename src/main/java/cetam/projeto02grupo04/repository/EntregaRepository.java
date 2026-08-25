package cetam.projeto02grupo04.repository;

import cetam.projeto02grupo04.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EntregaRepository extends JpaRepository<Entrega, Integer> {

    List<Entrega> findByPessoaIdPessoa(Integer idPessoa);
}