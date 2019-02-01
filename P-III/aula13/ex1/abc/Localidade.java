package aula13.ex1.abc;

public class Localidade extends Regiao {
    private TipoLocalidade tipo;


    public Localidade(String nome, int populacao, TipoLocalidade tipo) {
        super(nome, populacao);
        this.tipo = tipo;
    }

    public TipoLocalidade getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Localidade)) return false;
        if (!super.equals(o)) return false;

        Localidade that = (Localidade) o;

        return tipo == that.tipo;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return tipo + " " + super.toString();
    }
}
