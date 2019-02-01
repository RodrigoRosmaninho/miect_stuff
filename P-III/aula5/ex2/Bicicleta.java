package aula5.ex2;

public class Bicicleta extends Veiculo {

	public Bicicleta(int ano, String cor, double velMax) {
		super(ano,cor,2,velMax);
	}
	
	public String toString() {
		return "Bicicleta" + super.toString();
	}
}
