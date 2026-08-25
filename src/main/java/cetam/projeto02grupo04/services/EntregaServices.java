package cetam.projeto02grupo04.services;

import cetam.projeto02grupo04.model.Entrega;
import cetam.projeto02grupo04.repository.EntregaRepository; // <-- FALTAVA ESTE IMPORT
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EntregaServices {

    @Autowired
    private EntregaRepository repository;

    // Salva uma entrega
    public void salvar(Entrega entrega) {

        // Verifica se a pessoa foi informada
        if (entrega.getIdPessoa() == null) {
            throw new IllegalArgumentException(
                    "A pessoa deve ser informada."
            );
        }

        // Verifica se o endereço foi informado
        if (entrega.getIdEndereco() == null) {
            throw new IllegalArgumentException(
                    "O endereço deve ser informado."
            );
        }

        // Define o status padrão
        if (entrega.getStatusEntrega() == null ||
                entrega.getStatusEntrega().isBlank()) {

            entrega.setStatusEntrega("Em Processamento");
        }

        // Salva no banco de dados
        repository.save(entrega);
    }
}