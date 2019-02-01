package aula6.ex1;

public class Carne extends Alimento{
    enum Variedade{
        vaca, porco, peru, frango, outra;
    }

    private Variedade variedade;

    public Carne(Variedade variedade, double proteinas, double calorias, double peso) throws Exception {
        super(proteinas,calorias,peso);
        this.variedade = variedade;
    }

    public Variedade getVariadade(){
        return variedade;
    }

    public String toString() {
        return "Carne " + variedade + ", " + super.toString();
    }

    public boolean equals(Object obj){
        if(obj instanceof Carne){
            Carne c = (Carne) obj;
            return variedade.equals(c.getVariadade()) && super.equals(c);
        }
        return false;
    }
}