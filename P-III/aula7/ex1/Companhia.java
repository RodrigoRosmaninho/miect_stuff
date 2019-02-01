package aula7.ex1;

public class Companhia implements Comparable{
    private final String nome;
    private final String sigla;
    private Hora atrasoTotal;
    private int numVoos;

    public Companhia(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
        atrasoTotal = new Hora(0,0);
        numVoos = 0;
    }

    public void addVoo(Hora atraso){
        atrasoTotal = Hora.somarHoras(atrasoTotal, atraso);
        numVoos++;
    }

    public Hora getMedia(){
        if(numVoos == 0) return atrasoTotal;
        return new Hora(atrasoTotal.getMinutos() / numVoos);
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public Hora getAtrasoTotal() {
        return atrasoTotal;
    }

    public int getNumVoos() {
        return numVoos;
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Companhia)) throw new IllegalArgumentException("Companhia Inválida!");
        Companhia c = (Companhia) o;
        return getMedia().compareTo(c.getMedia());
    }

    public String toString(){
        return nome + "\t" + getMedia();
    }
}
