package cetam.projeto02grupo04.repository;
import cetam.projeto02grupo04.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    default List<Endereco> findByPessoaIdPessoa(Long attr0) {
        return null;
    }
}
