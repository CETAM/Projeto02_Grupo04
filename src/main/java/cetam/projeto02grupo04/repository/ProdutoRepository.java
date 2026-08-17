package cetam.projeto02grupo04.repository;

import cetam.projeto02grupo04.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // Buscar todos os produtos de uma determinada categoria pelo ID
    List<Produto> findByCategoriaId(Long categoriaId);

    // Buscar produtos contendo um termo no nome (busca insensível a maiúsculas/minúsculas)
    List<Produto> findByNomeContainingIgnoreCase(String nome);
}