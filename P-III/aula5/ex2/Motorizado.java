package aula5.ex2;

public abstract class Motorizado extends Veiculo {
	private int potencia;
	private double consumo;
	private double combustivel;
	private double cilindrada;
	private String matricula;
	
	public Motorizado(int ano, String cor, int numRodas, double velMax, int potencia, double consumo, double combustivel, double cilindrada, String matricula) {
		super(ano, cor, numRodas, velMax);
		this.potencia = potencia;
		this.consumo = consumo;
		this.combustivel = combustivel;
		this.cilindrada = cilindrada;
		this.matricula = matricula;
	}
	
	public String toString() {
		return super.toString() + ", potencia: " + potencia + ", consumo: " + consumo + ", combustivel: " + combustivel + ", cilindrada: " + cilindrada + ", matricula: " + matricula;
	}
	
	public int getPotencia() {
		return potencia;
	}
	public double getConsumo() {
		return consumo;
	}
	public double getCombustivel() {
		return combustivel;
	}
	public double getCilindrada() {
		return cilindrada;
	}
	public String getMatricula() {
		return matricula;
	}
}
