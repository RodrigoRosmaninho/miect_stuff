package aula5.ex2;

public class MotoPolicia extends Moto implements Policia{
	private Tipo tipo;
	private String ID;

	public MotoPolicia(int ano, String cor, double velMax, int potencia, double consumo, double combustivel, double cilindrada, String matricula, Tipo tipo, String ID) {
		super(ano, cor, velMax, potencia, consumo, combustivel, cilindrada, matricula);
		this.tipo = tipo;
		this.ID = ID;
	}
	
	public String toString() {
		return "Polícia-" + super.toString() + ", tipo: " + tipo + ", ID: " + ID;
	}

	@Override
	public Tipo getTipo() {
		return tipo;
	}

	@Override
	public String getID() {
		return ID;
	}
}
