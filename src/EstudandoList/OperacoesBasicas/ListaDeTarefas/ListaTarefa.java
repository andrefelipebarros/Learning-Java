package EstudandoList.OperacoesBasicas.ListaDeTarefas;

import java.util.List;
import java.util.ArrayList;

public class ListaTarefa {
    //atributo
    private  List<Tarefa> tarefaList;

    //constructor
    public ListaTarefa(){
        this.tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        List<Tarefa> tarefaParaRemover = new ArrayList<>();
        for (Tarefa t : tarefaList){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                tarefaParaRemover.add(t);
            }
        }

        tarefaList.removeAll(tarefaParaRemover);
    }

    public int obterNumeroTotalDeTarefas(){
        return tarefaList.size();
    }

    public void obterDescricoesTarefas(){
        System.out.println(tarefaList);
    }

    public static void main(String[] args) {
        //criando a LISTA(ArrayList) com o nome "listaTarefa":
        ListaTarefa listaTarefaDoDede = new ListaTarefa();

        System.out.println("O número máximo de elementos é: " + listaTarefaDoDede.obterNumeroTotalDeTarefas());

        //adicionando tarefa:
        listaTarefaDoDede.adicionarTarefa("Limpar a Casa");
        listaTarefaDoDede.adicionarTarefa("Estudar Java");

        // foi agregado duas tarefas:
        System.out.println("O número máximo de elementos é: " + listaTarefaDoDede.obterNumeroTotalDeTarefas());

        // removendo uma tarefa:
        listaTarefaDoDede.removerTarefa("Limpar a Casa");
        // como não possui um inteiro na class tarefa como um ID tem que escrever a tarefa por completo.
        
        // foi removido uma tarefa:
        System.out.println("O número máximo de elementos é: " + listaTarefaDoDede.obterNumeroTotalDeTarefas());

        //chamando tarefa que sobrou
        listaTarefaDoDede.obterDescricoesTarefas();
        //aqui vai pegar onde está na memória, queremos vizualizar o objeto
        
    }
}
