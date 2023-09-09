package EstudandoList.OrdenacaoList;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class OrdenacaoPessoa {
    private List<Pessoa> pessoaList;

    public OrdenacaoPessoa(){
        this.pessoaList = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade , double altura){
        pessoaList.add( new Pessoa(nome, idade, altura));
    }

    //MÉTODO UTILIZANDO COMPARABLE:
    public List<Pessoa> ordenadoPorIdade(){
        //gera uma nova lista com uma arraylist contendo as informações da lista main
        List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoaList);
        //após isso utiliza o método sort:
        Collections.sort(pessoasPorIdade);
        return pessoasPorIdade;
    }

    //MÉTODO UTILIZANDO COMPARATOR:
    public List<Pessoa> ordenarPorAltura(){
        List<Pessoa> pessoaPorAltura = new ArrayList<>(pessoaList);
        Collections.sort(pessoaPorAltura, new ComparatorPorAltura());
        return pessoaPorAltura;
    }

    public static void main(String[] args) {
        OrdenacaoPessoa AndreList = new OrdenacaoPessoa();

        AndreList.adicionarPessoa("André", 19, 1.81);
        AndreList.adicionarPessoa("José", 28, 1.62);
        AndreList.adicionarPessoa("Jota", 12, 1.80);

        System.out.println("ORDEM POR IDADE: ");
        System.out.println(AndreList.ordenadoPorIdade());
        System.out.println(" ");
        System.out.println("ORDEM POR ALTURA: ");
        System.out.println(AndreList.ordenarPorAltura());

    }
}
