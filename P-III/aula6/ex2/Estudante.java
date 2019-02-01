package aula6.ex2;

import java.util.GregorianCalendar;

public class Estudante extends Pessoa {
	private Data dataInsc;
	private static int nMec_global = 100;
	private int nMec;

	public Estudante(String nome, int cc, Data dataNasc, Data dataInsc) {
		super(nome, cc, dataNasc);
		this.dataInsc = dataInsc;
		nMec = nMec_global++;
	}
	
	public Estudante(String nome, int cc, Data dataNasc) {
		super(nome, cc, dataNasc);
		GregorianCalendar cal = new GregorianCalendar();
		dataInsc = new Data(cal.get(cal.DAY_OF_MONTH), cal.get(cal.MONTH) + 1, cal.get(cal.YEAR));
		nMec = nMec_global++;
	}
	
	public int nMec() {
		return nMec;
	}
	
	public Data dataInsc() {
		return dataInsc;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", NMec: " + nMec + ", inscrito em Data: " + dataInsc;
	}

}
