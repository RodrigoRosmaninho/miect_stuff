package aula9.ex2;

public class GeladoSimples implements Gelado {
    private String sabor;

    public GeladoSimples(String sabor) {
        this.sabor = sabor;
    }

    public void base(int bolas) {
        System.out.print("\n" + bolas + " bolas de gelado de " + sabor);
    }
}
