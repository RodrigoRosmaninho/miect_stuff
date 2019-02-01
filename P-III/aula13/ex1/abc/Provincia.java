package aula13.ex1.abc;

public class Provincia extends Regiao {
    private String governador;

    public Provincia(String nome, int populacao, String governador) {
        super(nome, populacao);
        this.governador = governador;
    }

    public String getGovernador() {
        return governador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Provincia)) return false;
        if (!super.equals(o)) return false;

        Provincia provincia = (Provincia) o;

        return governador != null ? governador.equals(provincia.governador) : provincia.governador == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (governador != null ? governador.hashCode() : 0);
        return result;
    }
}
