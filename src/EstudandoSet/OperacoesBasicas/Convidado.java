package OperacoesBasicas.EstudandoSet.OperacoesBasicas;

public class Convidado {
    private String nome;
    private int codigoConvite;

    public Convidado(String nome, int codigoConvite){
        this.nome = nome;
        this.codigoConvite = codigoConvite;
    }

    public int getCodigoConvite() {
        return codigoConvite;
    }
    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(!(obj instanceof Convidado c)) return false;
        return getCodigoConvite() == c.getCodigoConvite();
    }

    @Override
    public String toString(){
        return "Convidado:" + nome + " " + codigoConvite + " / ";
    }

}
