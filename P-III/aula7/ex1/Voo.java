package aula7.ex1;

public class Voo implements Comparable{
    private Hora partida;
    private String id;
    private Companhia companhia;
    private Cidade origem;
    private Hora atraso;
    private String obs;

    public Voo(Hora partida, String id, Companhia companhia, Cidade origem, Hora atraso) {
        this.partida = partida;
        this.id = id;
        this.companhia = companhia;
        this.origem = origem;
        this.atraso = atraso;
        if(atraso != null) obs = "Previsto: " + Hora.somarHoras(partida,atraso);
        origem.addVoo();
        companhia.addVoo(atraso);
    }

    public Hora getPartida() {
        return partida;
    }

    public String getId() {
        return id;
    }

    public Companhia getCompanhia() {
        return companhia;
    }

    public Cidade getOrigem() {
        return origem;
    }

    public Hora getAtraso() {
        return atraso;
    }

    public String getObs() {
        return obs;
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Voo)) throw new IllegalArgumentException("Voo Inválida!");
        Voo v = (Voo) o;
        return partida.compareTo(v.getPartida());
    }

    public String toString(){
        if(atraso == null) return partida + "\t" + id + "\t" + companhia.getNome() + "\t" + origem.getNome();
        else return partida + "\t" + id + "\t" + companhia.getNome() + "\t" + origem.getNome() + "\t" + atraso + "\t" + obs;
    }
}
