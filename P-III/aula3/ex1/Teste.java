package aula3.ex1;

public class Teste {
	public static void main(String[] args) throws DateValidationException {
		Estudante est = new Estudante ("Andreia", 9855678, new Data(18, 7, 1974));
		Bolseiro bls = new Bolseiro ("Maria", 8976543, new Data(11, 5, 1976));
		bls.setBolsa(745);
		 
		System.out.println("Estudante: " + est.nome());
		System.out.println(est);

		System.out.println("Bolseiro: " + bls.nome() + ", NMec: " + bls. nMec() + ", Bolsa:" + bls.bolsa());
		System.out.println(bls);
	}	
}
