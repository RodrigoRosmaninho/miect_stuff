package aula3.ex3;

public class Motor {
	private double cilindrada;
	private double potencia;
	
	public Motor(double cilindrada, double potencia) {
		this.cilindrada = cilindrada;
		this.potencia = potencia;
	}

	public double getCilindrada() {
		return cilindrada;
	}

	public double getPotencia() {
		return potencia;
	}
	
	public String toString() {
		return "cilindrada: " + cilindrada + ", potencia: " + potencia;
	}
	
	public boolean equals(Motor m) {
		return cilindrada == m.getCilindrada() && potencia == m.getPotencia();
	}
}
