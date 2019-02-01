package aula11.ex3;

public class PratoVegetariano extends Prato {
    
    public PratoVegetariano(String nome) throws Exception {
        super(nome);
    }

    public boolean addIngrediente(Alimento a){
        if(a instanceof Vegetariano) return super.addIngrediente(a);
        return false;
    }

    public String toString(){
        return "Vegetariano " + super.toString();
    }

    public boolean equals(Object obj){
        if(obj instanceof PratoVegetariano) return super.equals(obj);
        return false;
    }
}