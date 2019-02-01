package aula3.ex3;

public class Veiculo {
	private Motor motor;
	private int lotacao;
	private char tipo;
	private double peso_bruto;
	private Condutor condutor;
	
	public Veiculo(double cilindrada, int potencia, int lotacao, char tipo, double peso_bruto, Condutor condutor) {
		motor = new Motor(cilindrada, potencia);
		this.lotacao = lotacao;
		this.tipo = tipo;
		this.peso_bruto = peso_bruto;
		int tipo_index = Condutor.charToTipo(tipo);
		if(condutor.getTipo()[tipo_index]) this.condutor = condutor;
		else this.condutor = null; // condutor não pode conduzir este veiculo!!
	}

	public Motor getMotor() {
		return motor;
	}

	public int getLotacao() {
		return lotacao;
	}

	public char getTipo() {
		return tipo;
	}

	public double getPeso_bruto() {
		return peso_bruto;
	}
	
	public Condutor getCondutor() {
		return condutor;
	}
	
	public String toString() {
		if (condutor != null) return motor + ", lotacao: " + lotacao + ", tipo: " + tipo + ", peso: " + peso_bruto + ", Condutor: " + condutor;
		else return "Erro! O condutor indicado não pode conduzir o veículo!";
	}
	
	public boolean equals(Veiculo v) {
		return motor.equals(motor) && lotacao == v.getLotacao() && tipo == v.getTipo() && peso_bruto == v.getPeso_bruto(); // Não se verifica o condutor
	}
	
}
