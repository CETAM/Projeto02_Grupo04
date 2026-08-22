package cetam.projeto02grupo04.services;
import cetam.projeto02grupo04.model.FormadePagamento;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class FormadePagamentoServices {
    public List<FormadePagamento> listarFormasPagamento() {
        return Arrays.asList(FormadePagamento.values());
    }
}
