package prepteste.g13e1;

import java.util.ArrayList;
import java.util.List;

public class Pais {
    private String nome;
    private Localidade capital;
    private List<Regiao> regioes;
    private int  popTotal;

    public Pais(String nome, Localidade capital) {
        if(!capital.getTipo().equals(TipoLocalidade.Cidade)) throw new IllegalArgumentException("Cidade Inválida!");
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

    public Localidade getCapital() {
        return capital;
    }

    public List<Regiao> getRegioes() {
        return regioes;
    }

    public int getPopTotal() {
        return popTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pais)) return false;

        Pais pais = (Pais) o;

        if (getPopTotal() != pais.getPopTotal()) return false;
        if (getNome() != null ? !getNome().equals(pais.getNome()) : pais.getNome() != null) return false;
        if (getCapital() != null ? !getCapital().equals(pais.getCapital()) : pais.getCapital() != null) return false;
        return getRegioes() != null ? getRegioes().equals(pais.getRegioes()) : pais.getRegioes() == null;
    }

    @Override
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 0;
        result = 31 * result + (getCapital() != null ? getCapital().hashCode() : 0);
        result = 31 * result + (getRegioes() != null ? getRegioes().hashCode() : 0);
        result = 31 * result + getPopTotal();
        return result;
    }

    @Override
    public String toString() {
        if (capital == null) return "Pais: " + nome + ", População: " + popTotal + " (Capital: *Indefinida*)";
        else return "Pais: " + nome + ", População: " + popTotal + " (Capital: " + capital + ")";
    }
}
