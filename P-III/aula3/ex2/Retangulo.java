package aula3.ex2;

public class Retangulo extends Figura{
    private Ponto p_sup_esquerdo;
    private Ponto p_inf_direito;

    public Retangulo(Ponto p_sup_esquerdo, Ponto p_inf_direito) {
        this.p_sup_esquerdo = p_sup_esquerdo;
        this.p_inf_direito = p_inf_direito;
    }
    
    public Retangulo(double abcissa1, double ordenada1) {
        this.p_sup_esquerdo = new Ponto(0, 0);
        this.p_inf_direito = new Ponto(abcissa1, ordenada1);
    }

    public Retangulo(double abcissa1, double ordenada1, double abcissa2, double ordenada2) {
        this.p_sup_esquerdo = new Ponto(abcissa1, ordenada1);
        this.p_inf_direito = new Ponto(abcissa2, ordenada2);
    }
    
    public Retangulo(Retangulo r) {
    	p_sup_esquerdo = r.getP_sup_esquerdo();
    	p_inf_direito = r.getP_inf_direito();
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
    
    public boolean equals(Retangulo r){
        return p_sup_esquerdo.equals(r.getP_sup_esquerdo()) && p_inf_direito.equals(r.getP_inf_direito());
    }
}
