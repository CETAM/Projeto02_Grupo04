
package cetam.projeto02grupo04.repository;

import cetam.projeto02grupo04.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("all")
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    List<Produto> findByNomeContainingIgnoreCase(String nome);

    List<Produto> findByIdCategoria(Integer idCategoria);


}