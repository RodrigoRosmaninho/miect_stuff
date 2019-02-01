package aula5.ex2;

public class Moto extends Motorizado {

	public Moto(int ano, String cor, double velMax, int potencia, double consumo, double combustivel, double cilindrada, String matricula) {
		super(ano, cor, 2, velMax, potencia, consumo, combustivel, cilindrada, matricula);
	}
	
	public String toString() {
		return "Moto" + super.toString();
	}
}
