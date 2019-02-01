package aula13.ex1.d;

public class Vila extends Localidade{

    public Vila(String nome, int populacao) {
        super(nome, populacao);
    }

    @Override
    public String toString() {
        return "Vila " + super.toString();
    }
}
