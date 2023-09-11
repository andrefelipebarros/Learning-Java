package EstudandoList.OrdenacaoList;

import java.util.Comparator;

public class Pessoa implements Comparable<Pessoa>{
    
    private String nome;
    private int idade;
    private double altura;
    //constructor:
    public Pessoa(String nome, int idade, double altura){
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }
    
        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        public void setAltura(double altura) {
            this.altura = altura;
        }

        public double getAltura() {
            return altura;
        }
        public int getIdade() {
            return idade;
        }
        public String getNome() {
            return nome;
        }        
        
        @Override
        public String toString(){
            //depois eu deixa bonitinho.
            return  "Nome: " + nome + "Idade: " + idade + "Altura: " + altura + "/ ";
        }

        @Override
        public int compareTo(Pessoa p) { //normalmente é "o" de object mas nomiarei como p
            return  Integer.compare(idade, p.getIdade()); //o compare já automaticamente compara dois inteiros.
        }
}

//Tem que ser o uso fora da class Pessoa.
class ComparatorPorAltura implements Comparator<Pessoa> {

    @Override //"compare(Pessoa o1, Pessoa o2)" o de Objeto.
    public int compare(Pessoa o1, Pessoa o2) {
        return Double.compare(o1.getAltura(), o2.getAltura());
    }

}
