package aula13.ex1.abc;

public class Regiao {
    private String nome;
    private int populacao;

    public Regiao(String nome, int populacao) {
        this.nome = nome;
        this.populacao = populacao;
    }

    public String getNome() {
        return nome;
    }

    public int getPopulacao() {
        return populacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Regiao)) return false;

        Regiao regiao = (Regiao) o;

        if (populacao != regiao.populacao) return false;
        return nome != null ? nome.equals(regiao.nome) : regiao.nome == null;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + populacao;
        return result;
    }

    @Override
    public String toString() {
        return nome + ", população " + populacao;
    }
}
