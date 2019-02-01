package aula3.ex2;

public class Circulo extends Figura{
    private double raio;
    private Ponto centro;

    public Circulo(Ponto centro, double raio) {
        this.centro = centro;
        this.raio = raio;
    }
    
    public Circulo(Circulo c) {
    	centro = c.getCentro();
    	raio = c.getRaio();
    }
    
    public Circulo(double raio) {
        centro = new Ponto(0, 0);
        this.raio = raio;
    }

    public Circulo(double abcissa, double ordenada, double raio) {
        this.centro = new Ponto(abcissa, ordenada);
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public Ponto getCentro() {
        return centro;
    }

    public double getArea() {
        return Math.PI * raio * raio;
    }

    public double getPerimetro() {
        return 2 * Math.PI * raio;
    }

    public boolean equals(Circulo c){
        return this.centro.equals(c.getCentro()) && this.raio == c.getRaio();
    }

    public String toString(){
        return "\nRaio: " + raio + "\nCentro: " + centro.getXX() + "," + centro.getYY() + "\nArea: " + getArea() + "\nPerimetro: " + getPerimetro();
    }
    
}
