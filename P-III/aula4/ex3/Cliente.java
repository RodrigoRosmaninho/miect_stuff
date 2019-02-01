package aula4.ex3;

public abstract class Cliente {
	private int SID; // Sócio ID
	private Data inscricao;
	private String nome;
	private int CC;
	private Data nascimento;
	private int num_reqs;
	
	public Cliente(int sID, Data inscricao, String nome, int cC, Data nascimento) {
		SID = sID;
		this.inscricao = inscricao;
		this.nome = nome;
		CC = cC;
		this.nascimento = nascimento;
		num_reqs = 0;
	}

	public int getSID() {
		return SID;
	}

	public Data getInscricao() {
		return inscricao;
	}

	public String getNome() {
		return nome;
	}

	public int getCC() {
		return CC;
	}

	public Data getNascimento() {
		return nascimento;
	}
	
	public int getNum_reqs() {
		return num_reqs;
	}
	
	public void check_in() {
		num_reqs--;
	}
	
	public void check_out() {
		num_reqs++;
	}

	public String toString() {
		return "#" + SID + " - " + nome + " - " + CC + " - " + nascimento + " - " + inscricao;
	}
	
	

}
