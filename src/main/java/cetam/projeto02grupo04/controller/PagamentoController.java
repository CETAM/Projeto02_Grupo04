import cetam.projeto02grupo04.model.FormadePagamento;
import cetam.projeto02grupo04.services.PagamentoServices;
import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoServices pagamentoService;

    public PagamentoController(PagamentoServices pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    // Exibe a tela de checkout/pagamento para um pedido específico
    @GetMapping("/novo/{idPedido}")
    public String exibirFormularioPagamento(@PathVariable Long idPedido, Model model) {
        FormadePagamento form = new FormadePagamento();
        form.setIdPedido(idPedido);

        model.addAttribute("FormadePagamento", form);
        return "pagamento/formulario";
    }

    // Processa o pagamento enviado pelo usuário
    @PostMapping("/processar")
    public String processarPagamento(@ModelAttribute("FormadePagamento") FormadePagamento form, RedirectAttributes redirectAttributes) {
        try {
            pagamentoService.realizarPagamento(form);
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Pagamento aprovado com sucesso!");
            return "redirect:/pedidos/confirmacao/" + form.getIdPedido();
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("mensagemErro", e.getMessage());
            return "redirect:/pagamentos/novo/" + form.getIdPedido();
        }
    }
}