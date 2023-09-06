package OperacoesBasicas.EstudandoList.CarrinhoDeCompras;

public class Carrinho {
    String produto;
    int id;
    Double preco;
    //constructor:
    public Carrinho(String produto, int id, Double preco){
        this.produto = produto;
        this.id = id;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getProduto() {
        return produto;
    }

    public Double getPreco() {
        return preco;
    }

    @Override
    public String toString(){
        return produto;
    }

}
