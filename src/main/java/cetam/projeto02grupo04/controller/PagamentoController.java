package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.FormadePagamento;
import cetam.projeto02grupo04.model.StatusPagamento;
import cetam.projeto02grupo04.model.Pagamento;
import cetam.projeto02grupo04.services.PagamentoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoServices pagamentoServices;

    @GetMapping("/novo/{idPedido}")
    public String exibirFormularioPagamento(@PathVariable Integer idPedido, Model model) {
        Pagamento pagamento = new Pagamento();
        pagamento.setIdPedido(idPedido);
        pagamento.setStatusPagamento(StatusPagamento.Pendente);

        model.addAttribute("pagamento", pagamento);
        model.addAttribute("formasPagamento", FormadePagamento.values());
        model.addAttribute("statusPagamentoList", StatusPagamento.values());
        return "pagamento/formulario";
    }

    @PostMapping("/processar")
    public String processarPagamento(@ModelAttribute("pagamento") Pagamento pagamento, RedirectAttributes redirectAttributes) {
        try {
            pagamentoServices.salvar(pagamento);
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Pagamento registrado com sucesso!");
            return "redirect:/pedidos/confirmacao/" + pagamento.getIdPedido();
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao processar pagamento: " + e.getMessage());
            return "redirect:/pagamentos/novo/" + pagamento.getIdPedido();
        }
    }

    @GetMapping("/pedido/{idPedido}")
    public String buscarPorPedido(@PathVariable Integer idPedido, Model model) {
        pagamentoServices.buscarPorIdPedido(idPedido).ifPresentOrElse(
                pagamento -> model.addAttribute("pagamento", pagamento),
                () -> model.addAttribute("mensagemErro", "Pagamento não encontrado.")
        );
        return "pagamento/detalhes";
    }
}