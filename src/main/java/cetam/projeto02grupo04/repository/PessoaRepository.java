package cetam.projeto02grupo04.repository;

import cetam.projeto02grupo04.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findByTipoIgnoreCase(String tipo);

}