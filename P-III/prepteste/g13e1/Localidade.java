package prepteste.g13e1;

public class Localidade {
    private String nome;
    private int pop;
    private TipoLocalidade tipo;

    public Localidade(String nome, int pop, TipoLocalidade tipo) {
        this.nome = nome;
        this.pop = pop;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public int getPop() {
        return pop;
    }

    public TipoLocalidade getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Localidade)) return false;

        Localidade that = (Localidade) o;

        if (getPop() != that.getPop()) return false;
        if (getNome() != null ? !getNome().equals(that.getNome()) : that.getNome() != null) return false;
        return getTipo() == that.getTipo();
    }

    @Override
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 0;
        result = 31 * result + getPop();
        result = 31 * result + (getTipo() != null ? getTipo().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return tipo + " " + nome + ", população " + pop;
    }
}
