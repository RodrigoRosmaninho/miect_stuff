package aula1.ex3;

public class Ponto {
    private double xx;
    private double yy;

    public Ponto(){}

    public Ponto(double xx, double yy){
        this.xx = xx;
        this.yy = yy;
    }

    public double getXX() {
        return xx;
    }

    public double getYY() {
        return yy;
    }

    public double distancia(Ponto p){
        return Math.sqrt(Math.pow(p.getXX()-xx,2) + Math.pow(p.getYY()-yy,2));
    }

}
