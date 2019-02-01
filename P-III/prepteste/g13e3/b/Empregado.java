package prepteste.g13e3.b;

public class Empregado {
    private String nome;
    private int id;

    public Empregado(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Empregado " + id + ", " + nome;
    }
}
