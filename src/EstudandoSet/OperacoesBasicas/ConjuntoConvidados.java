package EstudandoSet.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    //utilizando "Set"
    private Set<Convidado> convidadosSet;

    public ConjuntoConvidados(){
        this.convidadosSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite){
        convidadosSet.add(new Convidado(nome , codigoConvite));
    }

    public void removerConvidadoPorCodigo(int codigoConvite){
        // !set só aceita elementos diferentes !
        Convidado convidadoRemove = null;
        for(Convidado c: convidadosSet){
            if(c.getCodigoConvite() == codigoConvite){
                convidadoRemove = c;
                break;
            }else{
                System.out.println("Não existe esse convidado.");
                break;
            }
        }

        convidadosSet.remove(convidadoRemove);
    }

    public void contarConvidados(){
        convidadosSet.size();
    }

    public void exibirConvidados(){
        System.out.println(convidadosSet);
    }

    public static void main(String[] args) {
        
    }
}
