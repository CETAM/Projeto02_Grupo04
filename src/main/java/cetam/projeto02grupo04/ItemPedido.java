package cetam.projeto02grupo04;

class ItemPedido {

    int idItemPedido;
    Pedido pedido;
    Produto produto;
    int quantidade;
    double precoUnitario;

    ItemPedido(int idItemPedido,
               Pedido pedido,
               Produto produto,
               int quantidade,
               double precoUnitario) {

        this.idItemPedido = idItemPedido;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    double calcularSubtotal() {

        return quantidade * precoUnitario;
    }
}

