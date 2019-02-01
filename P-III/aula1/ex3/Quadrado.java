package aula1.ex3;

public class Quadrado {
	private Ponto p_sup_esquerdo;
    private Ponto p_inf_direito;

    public Quadrado() {}

    public Quadrado(Ponto p_sup_esquerdo, Ponto p_inf_direito) {
        this.p_sup_esquerdo = p_sup_esquerdo;
        this.p_inf_direito = p_inf_direito;
    }

    public Quadrado(double abcissa1, double ordenada1, double abcissa2, double ordenada2) {
        this.p_sup_esquerdo = new Ponto(abcissa1, ordenada1);
        this.p_inf_direito = new Ponto(abcissa2, ordenada2);
    }

    public Ponto getP_sup_esquerdo() {
        return p_sup_esquerdo;
    }

    public Ponto getP_inf_direito() {
        return p_inf_direito;
    }

    public double getArea(){
        double lado = p_inf_direito.getXX() - p_sup_esquerdo.getXX();
        return Math.abs(lado) * Math.abs(lado);
    }

    public double getPerimetro(){
        double lado = p_inf_direito.getXX() - p_sup_esquerdo.getXX();
        return 2 * Math.abs(lado);
    }

    public String toString(){
        return "\nPonto Superior Esquerdo: " + p_sup_esquerdo.getXX() + ", " + p_sup_esquerdo.getYY() + "\nPonto Inferior Direito: " + p_inf_direito.getXX() + ", " + p_inf_direito.getYY() + "\nArea: " + getArea() + "\nPerimetro: " + getPerimetro();
    }
}
