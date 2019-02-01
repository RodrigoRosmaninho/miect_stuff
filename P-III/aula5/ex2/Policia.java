package aula5.ex2;

public interface Policia {
	
	public enum Tipo{
		INEM, Bombeiros, GNR, PSP, PJ;
	}
	
	public Tipo getTipo();
	public String getID();
}
