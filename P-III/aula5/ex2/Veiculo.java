package aula5.ex2;

public abstract class Veiculo implements Comparable<Veiculo>{
	private int ano;
	private String cor;
	private int numRodas;
	private double velMax;
	
	public Veiculo(int ano, String cor, int numRodas, double velMax) {
		this.ano = ano;
		this.cor = cor;
		this.numRodas = numRodas;
		this.velMax = velMax;
	}

	public int compareTo(Veiculo v) {
		if(ano < v.getAno()) return -1;
		if(ano > v.getAno()) return 1;
		return 0;
	}
	
	public String toString() {
		return " -> ano: " + ano + ", cor: "  + cor + ", numero de rodas: " + numRodas + ", velocidade maxima: " + velMax;
	}
	
	public int getAno() {
		return ano;
	}
	public String getCor() {
		return cor;
	}
	public int getNumRodas() {
		return numRodas;
	}
	public double getVelMax() {
		return velMax;
	}
}
