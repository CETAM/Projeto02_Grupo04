package cetam.projeto02grupo04.repository;

import cetam.projeto02grupo04.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
