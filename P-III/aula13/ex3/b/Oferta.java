package aula13.ex3.b;

public class Oferta {
    private Empregado empregado;
    private Brinquedo brinquedo;
    private int id;

    public Oferta(Empregado empregado, Brinquedo brinquedo, int id) {
        this.empregado = empregado;
        this.brinquedo = brinquedo;
        this.id = id;
    }

    public Empregado getEmpregado() {
        return empregado;
    }

    public Brinquedo getBrinquedo() {
        return brinquedo;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Oferta nº" + id + " -> " + empregado + " + " + brinquedo;
    }
}
