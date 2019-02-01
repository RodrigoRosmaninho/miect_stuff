package aula13.ex1.abc;

import java.util.ArrayList;
import java.util.List;

public class Pais {
    private String nome;
    private Localidade capital;
    private List<Regiao> regioes;
    private int popTotal;

    public Pais(String nome, Localidade capital) {
        this.nome = nome;
        if(!capital.getTipo().equals(TipoLocalidade.Cidade)) throw new IllegalArgumentException("Capital Inválida");
        this.capital = capital;
        popTotal = 0;
        regioes = new ArrayList<Regiao>();
    }

    public Pais(String nome) {
        this.nome = nome;
        regioes = new ArrayList<Regiao>();
    }

    public String getNome() {
        return nome;
    }

    public Localidade getCapital() {
        return capital;
    }

    public List<Regiao> getRegioes() {
        return regioes;
    }

    public void addRegiao(Regiao r){
        regioes.add(r);
        popTotal += r.getPopulacao();
    }

    public int getPopTotal() {
        return popTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pais)) return false;

        Pais pais = (Pais) o;

        if (popTotal != pais.popTotal) return false;
        if (nome != null ? !nome.equals(pais.nome) : pais.nome != null) return false;
        if (capital != null ? !capital.equals(pais.capital) : pais.capital != null) return false;
        return regioes != null ? regioes.equals(pais.regioes) : pais.regioes == null;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (regioes != null ? regioes.hashCode() : 0);
        result = 31 * result + popTotal;
        return result;
    }

    @Override
    public String toString() {
        if(capital == null) return "Pais: " + nome + ", População: " + popTotal + " (Capital: *Indefinida*)";
        return "Pais: " + nome + ", População: " + popTotal + " (Capital: " + capital + ")";
    }
}
