package prepteste.g13e3.b;

public class Oferta {
    private Empregado e;
    private Brinquedo b;

    public Oferta(Empregado e, Brinquedo b) {
        this.e = e;
        this.b = b;
    }

    public Empregado getE() {
        return e;
    }

    public Brinquedo getB() {
        return b;
    }

    @Override
    public String toString() {
        return "Oferta: " + b + " -> " + e;
    }
}
