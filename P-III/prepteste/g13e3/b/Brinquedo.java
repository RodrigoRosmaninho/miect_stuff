package prepteste.g13e3.b;

public class Brinquedo {
    String nome;

    public Brinquedo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
