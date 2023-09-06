package OperacoesBasicas.EstudandoList.PesquisaList.Pesquisa;

import java.util.List;
import java.util.ArrayList;

public class CatalogoLivro {
    // sem necessidade de ser público:
    private List<Livro> livroList;

    //constructor:
    public CatalogoLivro(){
        //adicionando uma array vazia a livroLista que contém a class Livro;
        this.livroList = new ArrayList<>();
    }


    public void AdicionarLivro(String titulo, String autor, int anoPublicado){
        livroList.add(new Livro(titulo, autor, anoPublicado));
    }


    public List<Livro> pesquisarAutor(String autor){
        List<Livro> AutorList = new ArrayList<>();

        for (Livro l : livroList) {
            if(l.getAutor().equalsIgnoreCase(autor)){
                AutorList.add(l);
            }
        }
        return AutorList;
    }

    public int NumeroDeLivros(){
        return livroList.size();
    }


    public static void main(String[] args) {
        
        CatalogoLivro livroListAndre = new CatalogoLivro();

        livroListAndre.AdicionarLivro("INCRIVEL MUNDO DE GUMBALL", "Ben Bocquelet", 2011);

        System.out.println(livroListAndre.NumeroDeLivros());

        System.out.println(livroListAndre.pesquisarAutor("Ben Bocquelet"));

    }
}
