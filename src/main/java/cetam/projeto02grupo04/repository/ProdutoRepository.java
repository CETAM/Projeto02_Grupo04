package cetam.projeto02grupo04.repository;

import cetam.projeto02grupo04.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
=======

import cetam.projeto02grupo04.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cetam.projeto02grupo04.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
>>>>>>> 84691fad22a72bea5045625f5315b71a34dd4de7
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
