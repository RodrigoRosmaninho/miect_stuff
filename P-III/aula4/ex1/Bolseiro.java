package aula4.ex1;

public class Bolseiro extends Estudante{
	private int bolsa;

	public Bolseiro(String nome, int cc, Data dataNasc, Data dataInsc) {
		super(nome, cc, dataNasc, dataInsc);
	}

	public Bolseiro(String nome, int cc, Data dataNasc) throws DateValidationException {
		super(nome, cc, dataNasc);
	}
	
	public void setBolsa(int bolsa) {
		this.bolsa = bolsa;
	}
	
	public int bolsa() {
		return bolsa;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Bolsa: " + bolsa;
	}
}
