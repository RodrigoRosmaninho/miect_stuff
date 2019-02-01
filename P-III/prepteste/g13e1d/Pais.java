package prepteste.g13e1d;

import java.util.ArrayList;
import java.util.List;

public class Pais {
    private String nome;
    private Cidade capital;
    private List<Regiao> regioes;
    private int  popTotal;

    public Pais(String nome, Cidade capital) {
        this.nome = nome;
        this.capital = capital;
        regioes = new ArrayList<>();
        popTotal = capital.getPop();
    }

    public Pais(String nome) {
        this.nome = nome;
        regioes = new ArrayList<>();
        popTotal = 0;
    }

    public void addRegiao(Regiao regiao){
        regioes.add(regiao);
        popTotal += regiao.getPop();
    }

    public String getNome() {
        return nome;
    }

    public Cidade getCapital() {
        return capital;
    }

    public List<Regiao> getRegioes() {
        return regioes;
    }

    public int getPopTotal() {
        return popTotal;
    }



    @Override
    public String toString() {
        if (capital == null) return "Pais: " + nome + ", População: " + popTotal + " (Capital: *Indefinida*)";
        else return "Pais: " + nome + ", População: " + popTotal + " (Capital: " + capital + ")";
    }
}
