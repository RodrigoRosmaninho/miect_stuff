package aula13.ex3.e;

public class Empregado {
    private String primeiro_nome;
    private String ultimo_nome;
    private int id;
    private int bilhetes;

    public Empregado(String primeiro_nome, String ultimo_nome, int id) {
        this.primeiro_nome = primeiro_nome;
        this.ultimo_nome = ultimo_nome;
        this.id = id;
        bilhetes = 0;
    }

    public String getPrimeiro_nome() {
        return primeiro_nome;
    }

    public String getUltimo_nome() {
        return ultimo_nome;
    }

    public int getId() {
        return id;
    }

    public int getBilhetes() {
        return bilhetes;
    }

    public void setBilhetes(int bilhetes) {
        this.bilhetes = bilhetes;
    }

    public void incrementBilhetes(){
        bilhetes++;
    }

    @Override
    public String toString() {
        return "Empregado nº" + id + " - " + primeiro_nome + " " + ultimo_nome + " - " + bilhetes + " bilhetes";
    }
}
