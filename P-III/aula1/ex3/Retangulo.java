package aula1.ex3;

public class Retangulo {
    private Ponto p_sup_esquerdo;
    private Ponto p_inf_direito;

    public Retangulo() {}

    public Retangulo(Ponto p_sup_esquerdo, Ponto p_inf_direito) {
        this.p_sup_esquerdo = p_sup_esquerdo;
        this.p_inf_direito = p_inf_direito;
    }

    public Retangulo(double abcissa1, double ordenada1, double abcissa2, double ordenada2) {
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
        double comprimento = p_inf_direito.getXX() - p_sup_esquerdo.getXX();
        double largura = p_sup_esquerdo.getYY() - p_inf_direito.getYY();
        return Math.abs(comprimento) * Math.abs(largura);
    }

    public double getPerimetro(){
        double comprimento = p_inf_direito.getXX() - p_sup_esquerdo.getXX();
        double largura = p_sup_esquerdo.getYY() - p_inf_direito.getYY();
        return 2 * Math.abs(comprimento) + 2 * Math.abs(largura);
    }

    public String toString(){
        return "\nPonto Superior Esquerdo: " + p_sup_esquerdo.getXX() + ", " + p_sup_esquerdo.getYY() + "\nPonto Inferior Direito: " + p_inf_direito.getXX() + ", " + p_inf_direito.getYY() + "\nArea: " + getArea() + "\nPerimetro: " + getPerimetro();
    }

}
