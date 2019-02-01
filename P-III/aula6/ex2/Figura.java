package aula6.ex2;

public abstract class Figura implements Comparable<Figura>{
	private Ponto centro;
	
	public Ponto getCentro() {
		return centro;
	}
	
	public void setCentro(Ponto p) {
		centro = p;
	}
	
	public int compareTo(Figura f) {
		if(getArea() < f.getArea()) return -1;
		if(getArea() > f.getArea()) return 1;
		return 0;
	}
	
	public abstract double getArea();
	public abstract double getPerimetro();
	public abstract String toString();
}
