@Controller
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    // Exibe a tela de checkout/pagamento para um pedido específico
    @GetMapping("/novo/{idPedido}")
    public String exibirFormularioPagamento(@PathVariable Integer idPedido, Model model) {
        PagamentoForm form = new PagamentoForm();
        form.setIdPedido(idPedido);

        model.addAttribute("pagamentoForm", form);
        return "pagamento/formulario";
    }

    // Processa o pagamento enviado pelo usuário
    @PostMapping("/processar")
    public String processarPagamento(@ModelAttribute("pagamentoForm") PagamentoForm form, RedirectAttributes redirectAttributes) {
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
  