package cetam.projeto02grupo04.services;

import cetam.projeto02grupo04.model.PedidoItem;
import cetam.projeto02grupo04.repository.PedidoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoItemServices {

    @Autowired
    private PedidoItemRepository repository;

    public List<PedidoItem> listarPorPedido(Long pedidoId) {
        return repository.findByPedidoId(pedidoId);
    }

    public void salvar(PedidoItem pedidoItem) {
        repository.save(pedidoItem);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
