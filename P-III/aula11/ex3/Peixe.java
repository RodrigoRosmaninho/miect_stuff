package aula11.ex3;

public class Peixe extends Alimento {
    enum Tipo{
        congelado, fresco;
    }

    private Tipo tipo;

    public Peixe(Tipo tipo, double proteinas, double calorias, double peso) throws Exception {
        super(proteinas,calorias,peso);
        this.tipo = tipo;
    }

    public Tipo getTipo(){
        return tipo;
    }

    public String toString() {
        return "Peixe " + tipo + ", " + super.toString();
    }

    public boolean equals(Object obj){
        if(obj instanceof Peixe){
            Peixe p = (Peixe) obj;
            return tipo.equals(p.getTipo()) && super.equals(p);
        }
        return false;
    }
}