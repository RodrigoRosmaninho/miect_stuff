package aula11.ex3;

import java.io.Serializable;
import java.util.ArrayList;

public class Prato implements Comparable, Serializable  {
    private String nome;
    private ArrayList<Alimento> composicao;
    private double proteinas = 0;
    private double calorias = 0;
    private double peso = 0;

    public Prato(String nome) throws Exception {
        if(nome.length() == 0) throw new Exception("O nome não foi preenchido!");
        this.nome = nome;
        composicao = new ArrayList<>();
    }

    public boolean addIngrediente(Alimento a){
        composicao.add(a);
        proteinas += (a.getProteinas() * a.getPeso()) / 100;
        calorias += (a.getCalorias() * a.getPeso()) / 100;
        peso += a.getPeso();
        return true;
    }

    public boolean removeIngrediente(Alimento a){
        if(composicao.remove(a)) {
            proteinas -= (a.getProteinas() * a.getPeso()) / 100;
            calorias -= (a.getCalorias() * a.getPeso()) / 100;
            peso -= a.getPeso();
            return true;
        }
        return false;
    }

    public String getNome(){
        return nome;
    }

    public ArrayList<Alimento> getComposicao(){
        return composicao;
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

    public int size(){
        return composicao.size();
    }

    public int compareTo(Object obj){
        if(obj instanceof Prato) {
            Prato p = (Prato) obj;
            if (calorias < p.getCalorias()) return -1;
            if (calorias > p.getCalorias()) return 1;
            return 0;
        }
        throw new IllegalArgumentException("Apenas se pode comparar um prato com outros pratos");
    }

    public String toString(){
        return "Prato '" + nome + "' composto por " + size() + " Ingredientes";
    }

    public boolean equals(Object obj){
        if(obj instanceof Prato){
            Prato p = (Prato) obj;
            return nome.equals(p.getNome()) && composicao.equals(p.getComposicao()) && proteinas == p.getProteinas() && calorias == p.getCalorias() && peso == p.getPeso();
        }
        return false;
    }
}