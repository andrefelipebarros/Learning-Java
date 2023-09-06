package OperacoesBasicas.StudandoList.CarrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;

public class ListaCarrinho {
    // List<Class>
    List<Carrinho> carrinhoLista;
    // constructor:
    public ListaCarrinho (){
        //gerando um array na Lista
        this.carrinhoLista = new ArrayList<>();
    }
    //Funcoes pedidas:
    public void adicionarNoCarrinho(String produto, int id, Double preco){
        carrinhoLista.add(new Carrinho(produto, id, preco)); //para adicionar chamamos a class Carrinho
    }
    //mais fácil remover pelo nome:
    public void removerProduto(String produto){
        List<Carrinho> removeCarrinho = new ArrayList<>();
        // fazer percorrer a lista:
        for(Carrinho c: carrinhoLista){
            //aqui ele faz a comparação de getProduto com produto e acrescenta
            if(c.getProduto().equalsIgnoreCase(produto)){
                removeCarrinho.add(c);
            }
        }
        carrinhoLista.removeAll(removeCarrinho);
    }

    public int tamanhoCarrinho(){
        return carrinhoLista.size();
    }

    public double calcularPrecoCarrinho() {
        //declarar double vazia
        double somaPrecos = 0;
        //criar um for para percorrer a lista:
        for(Carrinho c: carrinhoLista){
            // armazenar o preco a uma variavel
            double precoItem = c.getPreco();
            //eu fiz com que somaPrecos atribua o preco a variável, assim fazendo a soma.
            somaPrecos += precoItem;
        }
        return somaPrecos; // Retorna a soma total dos preços
    }

    public static void main(String[] args) {
        ListaCarrinho comprasDoDede = new ListaCarrinho();

        comprasDoDede.adicionarNoCarrinho("Doritos", 1, 9.50);

        comprasDoDede.adicionarNoCarrinho("Ruffles", 2, 12.50);

        System.out.println(comprasDoDede.tamanhoCarrinho());

        comprasDoDede.removerProduto("Doritos");

        System.out.println(comprasDoDede.tamanhoCarrinho());
        
        //adicionando novamente:
        comprasDoDede.adicionarNoCarrinho("Doritos", 1, 9.50);

        comprasDoDede.calcularPrecoCarrinho();

        System.out.println(comprasDoDede.calcularPrecoCarrinho());

    }

}
