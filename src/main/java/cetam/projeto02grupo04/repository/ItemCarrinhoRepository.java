package cetam.projeto02grupo04.repository;

import cetam.projeto02grupo04.model.ItemCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Integer> {

    List<ItemCarrinho> findByIdCarrinho(Integer idCarrinho);
}