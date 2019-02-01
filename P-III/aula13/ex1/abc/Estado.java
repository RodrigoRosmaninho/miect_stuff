package aula13.ex1.abc;

public class Estado extends Regiao {
    private Localidade capital;

    public Estado(String nome, int populacao, Localidade capital) {
        super(nome, populacao);
        if(!capital.getTipo().equals(TipoLocalidade.Cidade)) throw new IllegalArgumentException("Capital Inválida");
        this.capital = capital;
    }

    public Localidade getCapital() {
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
