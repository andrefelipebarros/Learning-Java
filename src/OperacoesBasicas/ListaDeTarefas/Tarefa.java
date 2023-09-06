package OperacoesBasicas.ListaDeTarefas;

public class Tarefa {
    //atributo
    private String descricao;
    //constructor
    public Tarefa(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return descricao;
    }

    // puxar informações do tipo string usando toString

    @Override
    public String toString(){
        return descricao + ".";
        //deixar detalhado: return "Tarefa{" + "descricao='" + descricao + "\'" + '}';
    }
}
