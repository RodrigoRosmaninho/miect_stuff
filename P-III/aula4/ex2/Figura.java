package aula4.ex2;

public abstract class Figura {
	private Ponto centro;
	
	public Ponto getCentro() {
		return centro;
	}
	
	public void setCentro(Ponto p) {
		centro = p;
	}
	
	public abstract double getArea();
	public abstract double getPerimetro();
	public abstract String toString();
}
