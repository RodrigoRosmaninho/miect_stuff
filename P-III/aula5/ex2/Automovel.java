package aula5.ex2;

public class Automovel extends Motorizado {
	public Automovel(int ano, String cor, double velMax, int potencia, double consumo, double combustivel, double cilindrada, String matricula) {
		super(ano, cor, 4, velMax, potencia, consumo, combustivel, cilindrada, matricula);
	}
	
	public String toString() {
		return "Automóvel" + super.toString();
	}
}
