package aula5.ex2;

public class BicicletaPolicia extends Bicicleta implements Policia{
	private Tipo tipo;
	private String ID;

	public BicicletaPolicia(int ano, String cor, double velMax, Tipo tipo, String ID) {
		super(ano, cor, velMax);
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
