package prepteste.g13e1d;

public class Provincia extends Regiao {
    private String governador;

    public Provincia(String nome, int pop, String governador) {
        super(nome, pop);
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

        return getGovernador() != null ? getGovernador().equals(provincia.getGovernador()) : provincia.getGovernador() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getGovernador() != null ? getGovernador().hashCode() : 0);
        return result;
    }
}
