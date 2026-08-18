package cetam.projeto02grupo04.repository;

import cetam.projeto02grupo04.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // Buscar categoria por nome
    Optional<Categoria> findByNome(String nome);
}
