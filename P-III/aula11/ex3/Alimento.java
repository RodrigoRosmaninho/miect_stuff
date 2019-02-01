package aula11.ex3;

import java.io.Serializable;

public abstract class Alimento implements Serializable {
    private double proteinas = 0;
    private double calorias = 0;
    private double peso = 0;

    public Alimento(double proteinas, double calorias, double peso) throws Exception {
        if(proteinas < 0 || calorias < 0 || peso < 0) throw new Exception("Apenas são aceites números inteiros/decimais positivos!");
        this.proteinas = proteinas;
        this.calorias = calorias;
        this.peso = peso;
    }

    public double getProteinas(){
        return proteinas;
    }

    public double getCalorias(){
        return calorias;
    }

    public double getPeso(){
        return peso;
    }

    public String toString(){
        return "Proteínas " + proteinas + ", Calorias " + calorias + ", Peso " + peso;
    }

    public boolean equals(Object obj){
        if(obj instanceof Alimento){
            Alimento a = (Alimento) obj;
            return proteinas == a.getProteinas() && calorias == a.getCalorias() && peso == a.getPeso();
        }
        return false;
    }
}