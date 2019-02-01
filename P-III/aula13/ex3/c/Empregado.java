package aula13.ex3.c;

public class Empregado {
    private String primeiro_nome;
    private String ultimo_nome;
    private int id;

    public Empregado(String primeiro_nome, String ultimo_nome, int id) {
        this.primeiro_nome = primeiro_nome;
        this.ultimo_nome = ultimo_nome;
        this.id = id;
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

    @Override
    public String toString() {
        return "Empregado nº" + id + " - " + primeiro_nome + " " + ultimo_nome;
    }
}
