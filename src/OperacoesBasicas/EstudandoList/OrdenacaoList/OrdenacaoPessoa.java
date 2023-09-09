package OperacoesBasicas.EstudandoList.OrdenacaoList;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class OrdenacaoPessoa {
    private List<Pessoa> pessoaList;

    public OrdenacaoPessoa(){
        this.pessoaList = new ArrayList<>();
    }

    public void AdicionarPessoa(String nome, int idade , double altura){
        pessoaList.add( new Pessoa(nome, idade, altura));
    }

    //MÉTODO UTILIZANDO COMPARABLE:
    public List<Pessoa> OrdenadoPorIdade(){
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
}
