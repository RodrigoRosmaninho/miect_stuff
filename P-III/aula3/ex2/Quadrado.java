package aula3.ex2;

public class Quadrado extends Retangulo {

    public Quadrado(Ponto p_sup_esquerdo, Ponto p_inf_direito) {
        super(p_sup_esquerdo, p_inf_direito);
    }

    public Quadrado(double abcissa1, double ordenada1, double lado) {
        super(new Ponto(abcissa1, ordenada1), new Ponto(abcissa1 + lado, ordenada1 - lado));
    }
    
    public Quadrado(double lado) {
        super(new Ponto(0, 0), new Ponto(0 + lado, 0 - lado));
    }
    
    public Quadrado(Quadrado q) {
    	super(q);
    }

    @Override
    public double getArea(){
        double lado = getP_inf_direito().getXX() - getP_sup_esquerdo().getXX();
        return Math.abs(lado) * Math.abs(lado);
    }

    @Override
    public double getPerimetro(){
        double lado = getP_inf_direito().getXX() - getP_sup_esquerdo().getXX();
        return 2 * Math.abs(lado);
    }
}
