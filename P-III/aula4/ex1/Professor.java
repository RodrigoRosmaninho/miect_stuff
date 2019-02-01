package aula4.ex1;

import java.util.GregorianCalendar;

public class Professor extends Pessoa {
	private Data dataInsc;
	private static int nFunc_global = 100;
	private int nFunc;

	public Professor(String nome, int cc, Data dataNasc, Data dataInsc) {
		super(nome, cc, dataNasc);
		this.dataInsc = dataInsc;
		nFunc = nFunc_global++;
	}
	
	public Professor(String nome, int cc, Data dataNasc) throws DateValidationException {
		super(nome, cc, dataNasc);
		GregorianCalendar cal = new GregorianCalendar();
		dataInsc = new Data(cal.get(cal.DAY_OF_MONTH), cal.get(cal.MONTH), cal.get(cal.YEAR));
		nFunc = nFunc_global++;
	}
	
	public int nFunc() {
		return nFunc;
	}
	
	public Data dataInsc() {
		return dataInsc;
	}
	
	@Override
	public String toString() {
		return "PROFESSOR: " + super.toString() + ", NFunc: " + nFunc + ", inscrito em Data: " + dataInsc;
	}

}
