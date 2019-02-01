package prepteste.g13e1d;

public class Estado extends Regiao {
    private Cidade capital;

    public Estado(String nome, int pop, Cidade capital) {
        super(nome, pop);
        this.capital = capital;
    }

    public Cidade getCapital() {
        return capital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estado)) return false;
        if (!super.equals(o)) return false;

        Estado estado = (Estado) o;

        return getCapital() != null ? getCapital().equals(estado.getCapital()) : estado.getCapital() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getCapital() != null ? getCapital().hashCode() : 0);
        return result;
    }
}
