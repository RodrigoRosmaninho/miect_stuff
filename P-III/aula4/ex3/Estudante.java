package aula4.ex3;

public class Estudante extends Cliente {
	private int MEC;
	private String curso;
	
	public Estudante(int sID, Data inscricao, String nome, int cC, Data nascimento, int mEC, String curso) {
		super(sID, inscricao, nome, cC, nascimento);
		MEC = mEC;
		this.curso = curso;
	}

	public int getMEC() {
		return MEC;
	}

	public String getCurso() {
		return curso;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - Estudante - " + MEC + " - " + curso;
	}
	
}
