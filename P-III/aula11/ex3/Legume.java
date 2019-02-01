package aula11.ex3;

public class Legume extends Alimento implements Vegetariano {
    private String nome;

    public Legume(String nome, double proteinas, double calorias, double peso) throws Exception {
        super(proteinas,calorias,peso);
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public String toString() {
        return "Legume '" + nome + "', " + super.toString();
    }

    public boolean equals(Object obj){
        if(obj instanceof Legume){
            Legume l = (Legume) obj;
            return nome.equals(l.getNome()) && super.equals(l);
        }
        return false;
    }
}