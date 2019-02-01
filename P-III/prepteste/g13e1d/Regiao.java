package prepteste.g13e1d;

public abstract class Regiao {
    private String nome;
    private int pop;

    public Regiao(String nome, int pop) {
        this.nome = nome;
        this.pop = pop;
    }

    public String getNome() {
        return nome;
    }

    public int getPop() {
        return pop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Regiao)) return false;

        Regiao regiao = (Regiao) o;

        if (getPop() != regiao.getPop()) return false;
        return getNome() != null ? getNome().equals(regiao.getNome()) : regiao.getNome() == null;
    }

    @Override
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 0;
        result = 31 * result + getPop();
        return result;
    }
}
