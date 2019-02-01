package aula7.ex1;

public class Cidade implements Comparable{
    private String nome;
    private int numVoos;

    public Cidade(String nome) {
        this.nome = nome;
        numVoos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getNumVoos() {
        return numVoos;
    }

    public void addVoo(){
        numVoos++;
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Cidade)) throw new IllegalArgumentException("Cidade Inválida!");
        Cidade c = (Cidade) o;
        return c.numVoos - numVoos;
    }

    @Override
    public String toString() {
        return nome + "\t" + numVoos;
    }
}
