package cetam.projeto02grupo04;

public class Pedido {

    int idPedido;
    String data;
    String status;

    Pedido(int idPedido, String data, String status) {

        this.idPedido = idPedido;
        this.data = data;
        this.status = status;
    }
}