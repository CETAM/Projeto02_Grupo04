package cetam.projeto02grupo04.repository;

import cetam.projeto02grupo04.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}