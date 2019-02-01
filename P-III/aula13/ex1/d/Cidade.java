package aula13.ex1.d;

public class Cidade extends Localidade {

    public Cidade(String nome, int populacao) {
        super(nome, populacao);
    }

    @Override
    public String toString() {
        return "Cidade " + super.toString();
    }
}
