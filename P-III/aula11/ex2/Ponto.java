package aula11.ex2;

public class Ponto {
	private double xx;
    private double yy;

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
    
    public boolean equals(Ponto p) {
    	return xx == p.getXX() && yy == p.getYY();
    }
    
    @Override
    public String toString() {
    	return "x: " + xx + ", y: " + yy;
    }
}
