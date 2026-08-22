package cetam.projeto02grupo04.controller;

import cetam.projeto02grupo04.model.FormadePagamento;
import cetam.projeto02grupo04.model.Pagamento;
import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService PagamentoService) {
        this.PagamentoService = PagamentoService;
    }

    // Exibe a tela de checkout/pagamento para um pedido específico
    @GetMapping("/novo/{idPedido}")
    public String exibirFormularioPagamento(@PathVariable Long idPedido, Model model) {
        Pagamento form = new Pagamento();
        form.setIdPedido(idPedido);


        model.addAttribute("pagamento", form);
        return "pagamento/formulario";
    }

    // Processa o pagamento enviado pelo usuário
    @PostMapping("/processar")
    public String processarPagamento(@ModelAttribute("Pagamento") Pagamento form, RedirectAttributes redirectAttributes) {
        try {
            pagamentoService.realizarPagamento(form);
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Pagamento aprovado com sucesso!");
            return "redirect:/pedidos/confirmacao/" + form.getPedido().getId();
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("mensagemErro", e.getMessage());
            return "redirect:/pagamentos/novo/" + form.getPedido().getId();
        }
    }
}
  