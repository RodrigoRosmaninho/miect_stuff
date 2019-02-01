package aula1.ex2;

public class Pessoa {
    private String nome;
    private int cc;
    private Data dataNasc;

    public Pessoa(){}

    public Pessoa(String nome, int cc, Data dataNasc){
        this.nome = nome;
        this.cc = cc;
        this.dataNasc = dataNasc;
    }

    public String getNome() {
        return nome;
    }

    public int getCC() {
        return cc;
    }

    public Data getDataNasc() {
        return dataNasc;
    }

    public String toString(){
        return this.nome + " - " + this.cc + " - " + this.dataNasc;
    }


}
