package aula11.ex2;

public class Circulo extends Figura {
    private double raio;

    public Circulo(Ponto centro, double raio) {
        setCentro(centro);
        this.raio = raio;
    }
    
    public Circulo(Circulo c) {
    	setCentro(c.getCentro());
    	raio = c.getRaio();
    }
    
    public Circulo(double raio) {
        setCentro(new Ponto(0, 0));
        this.raio = raio;
    }

    public Circulo(double abcissa, double ordenada, double raio) {
        setCentro(new Ponto(abcissa, ordenada));
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public double getArea() {
        return Math.PI * raio * raio;
    }

    public double getPerimetro() {
        return 2 * Math.PI * raio;
    }

    public boolean equals(Circulo c){
        return getCentro().equals(c.getCentro()) && this.raio == c.getRaio();
    }

    @Override
    public String toString(){
        return "Circulo de Centro " + getCentro() + " e de raio " + raio;
    }
    
}
