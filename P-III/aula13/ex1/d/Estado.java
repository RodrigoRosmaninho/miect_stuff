package aula13.ex1.d;

public class Estado extends Regiao {
    private Cidade capital;

    public Estado(String nome, int populacao, Cidade capital) {
        super(nome, populacao);
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

        return capital != null ? capital.equals(estado.capital) : estado.capital == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        return result;
    }
}
