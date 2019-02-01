package aula1.ex3;

public class Circulo {
    private double raio;
    private Ponto centro;

    public Circulo() {}

    public Circulo(Ponto centro, double raio) {
        this.centro = centro;
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

    public boolean iguais(Circulo c){
        return this.centro.equals(c.getCentro()) && this.raio == c.getRaio();
    }

    public boolean intersetam(Circulo c){
        return this.centro.distancia(c.getCentro()) <= this.raio + c.getRaio();
    }

    public String toString(){
        return "\nRaio: " + raio + "\nCentro: " + centro.getXX() + "," + centro.getYY() + "\nArea: " + getArea() + "\nPerimetro: " + getPerimetro();
    }
    
}
