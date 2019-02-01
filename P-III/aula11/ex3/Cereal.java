package aula11.ex3;

public class Cereal extends Alimento implements Vegetariano {
    private String nome;

    public Cereal(String nome, double proteinas, double calorias, double peso) throws Exception {
        super(proteinas,calorias,peso);
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public String toString() {
        return "Cereal '" + nome + "', " + super.toString();
    }

    public boolean equals(Object obj){
        if(obj instanceof Cereal){
            Cereal c = (Cereal) obj;
            return nome.equals(c.getNome()) && super.equals(c);
        }
        return false;
    }
}