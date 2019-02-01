package aula3.ex3;

public class Condutor {
	private String nome;
	private int cc;
	private boolean[] tipo; // A,B,C,D
	
	public Condutor(String nome, int cc, boolean[] tipo) {
		this.nome = nome;
		this.cc = cc;
		this.tipo = tipo;
	}
	
	public void setTipo(boolean value, int index) {
		tipo[index] = value;
	}

	public String getNome() {
		return nome;
	}

	public int getCc() {
		return cc;
	}

	public boolean[] getTipo() {
		return tipo;
	}
	
	public static String tipoToString(boolean[] tipos) {
		String A = "",B = "",C = "",D = "";
		if(tipos[0]) A = "A";
		if(tipos[1]) B = "B";
		if(tipos[2]) C = "C";
		if(tipos[3]) D = "D";
		return A + B + C + D;
	}
	
	public static int charToTipo(char c) {
		if(c == 'A') return 0;
		else if(c == 'B') return 1;
		else if(c == 'C') return 2;
		else return 3;
		
	}
	
	public String toString() {
		return nome + ", " + cc + ", " + tipoToString(tipo);
	}
}
