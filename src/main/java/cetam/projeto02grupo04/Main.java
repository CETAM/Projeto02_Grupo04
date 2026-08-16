package cetam.projeto02grupo04;

public class Main {

    public static void main(String[] args) {
        Produto produto = new Produto(
                1,
                "Vestido de Grife",
                "Gucci",
                "Vestido",
                "M",
                1500.00
        );

        Pedido pedido = new Pedido(
                1,
                "15/08/2026",
                "Em andamento"
        );

        ItemPedido item = new ItemPedido(
                1,
                pedido,
                produto,
                2,
                produto.preco
        );

        System.out.println("================================");
        System.out.println("          ITEM DO PEDIDO");
        System.out.println("================================");

        System.out.println("ID do Item: " + item.idItemPedido);
        System.out.println("ID do Pedido: " + item.pedido.idPedido);
        System.out.println("Data do Pedido: " + item.pedido.data);
        System.out.println("Status: " + item.pedido.status);

        System.out.println("--------------------------------");

        System.out.println("Produto: " + item.produto.nome);
        System.out.println("Marca: " + item.produto.marca);
        System.out.println("Categoria: " + item.produto.categoria);
        System.out.println("Tamanho: " + item.produto.tamanho);

        System.out.println("--------------------------------");

        System.out.println("Quantidade: " + item.quantidade);
        System.out.println("Preço Unitário: R$ " + item.precoUnitario);
        System.out.println("Subtotal: R$ " + item.calcularSubtotal());

        System.out.println("================================");
    }
}