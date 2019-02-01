package aula5.ex1;

public class Quadrado extends Retangulo {

    public Quadrado(double abcissa, double ordenada, double lado) {
        super(abcissa, ordenada, lado, lado);
    }
    
    public Quadrado(double lado) {
        super(lado, lado);
    }
    
    public Quadrado(Quadrado q) {
    	super(q);
    }

    @Override
    public double getArea(){
        double lado = getComprimento();
        return Math.abs(lado) * Math.abs(lado);
    }

    @Override
    public double getPerimetro(){
        double lado = getComprimento();
        return 2 * Math.abs(lado);
    }
    
    @Override
    public String toString(){
        return "Quadrado de Centro " + getCentro() + " e de lado " + getComprimento();
    }
}
