package EstudandoMap.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    //ATRIBUINDO DENTRO DE UM MAP
    private Map<String, Integer> agendaContatoMap; //Integer e não int.

    public AgendaContatos(){
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        //método "put" em vez de "add"
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome){
        //se o contato não estiver vazio: (isEmpty)
        if(agendaContatoMap.isEmpty()){
            agendaContatoMap.remove(nome);
        }
    }

    public void exibirContatos(){
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisarPorNome(String nome){
        Integer numeroPorNome = null;
        if(!agendaContatoMap.isEmpty()){
            numeroPorNome = agendaContatoMap.get(nome);
        }
        return numeroPorNome;
    }

    


}
