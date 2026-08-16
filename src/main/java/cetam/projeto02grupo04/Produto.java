package cetam.projeto02grupo04;

class Produto {

    int idProduto;
    String nome;
    String marca;
    String categoria;
    String tamanho;
    double preco;

    Produto(int idProduto, String nome, String marca,
            String categoria, String tamanho, double preco) {

        this.idProduto = idProduto;
        this.nome = nome;
        this.marca = marca;
        this.categoria = categoria;
        this.tamanho = tamanho;
        this.preco = preco;
    }
}