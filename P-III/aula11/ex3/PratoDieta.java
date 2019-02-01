package aula11.ex3;

public class PratoDieta extends Prato {

    private double limite;
    
    public PratoDieta(String nome, double limite) throws Exception {
        super(nome);
        if(limite <= 0) throw new Exception("O Limite não indicado não um número positivo!");
        this.limite = limite;
    }

    public boolean addIngrediente(Alimento a){
        if(super.getCalorias() + ((a.getCalorias() * a.getPeso()) / 100) <= limite) return super.addIngrediente(a);
        return false;
    }

    public double getLimite(){
        return limite;
    }

    public String toString(){
        return "Dieta (" + getCalorias() + " calorias) " + super.toString();
    }

    public boolean equals(Object obj){
        if(obj instanceof PratoDieta){
            PratoDieta pd = (PratoDieta) obj;
            return limite == pd.getLimite() && super.equals(pd);
        }
        return false;
    }
}