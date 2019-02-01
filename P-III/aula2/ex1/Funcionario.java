package aula2.ex1;

public class Funcionario extends Cliente{
	private int FID; // Func. ID
	private int NIF;

	public Funcionario(int sID, Data inscricao, String nome, int cC, Data nascimento, int fID, int nIF) {
		super(sID, inscricao, nome, cC, nascimento);
		FID = fID;
		NIF = nIF;
	}

	public int getFID() {
		return FID;
	}

	public int getNIF() {
		return NIF;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - Funcionário - " + FID + " - " + NIF;
	}

}
