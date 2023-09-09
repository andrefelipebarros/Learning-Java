package OperacoesBasicas.EstudandoList.PesquisaList.Pesquisa;

public class Livro {
    String titulo;
    String autor;
    int anoPublicado;

    public Livro(String titulo, String autor, int anoPublicado){
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicado = anoPublicado;
    }
    
    public int getAnoPublicado() {
        return anoPublicado;
    }
    
    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAnoPublicado(int anoPublicado) {
        this.anoPublicado = anoPublicado;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString(){
        return " / titulo: " + titulo + ".  / autor:" + autor + ".  / anoPublicado:" + anoPublicado + ".";
        //deixar detalhado: return "Tarefa{" + "descricao='" + descricao + "\'" + '}';
    }
}