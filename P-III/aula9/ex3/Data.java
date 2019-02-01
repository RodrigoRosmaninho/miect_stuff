package aula9.ex3;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public static int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static String[] mesesExtenso = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

    public Data() {
    }

    public Data(int dia, int mes, int ano) {
        if(data_valida(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }
        else{
            throw new IllegalArgumentException("Data Inválida!");
        }
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public static boolean bissexto(int ano) {
        return ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;
    }

    public static boolean data_valida(int d, int m, int a) {
        if (d > 0 && m > 0 && a >= 0 && m <= 12) {
            return d <= diasMes[m - 1] || (m == 2 && bissexto(a) && d <= 29);
        }
        return false;
    }

    public String toString(){
        return dia + " de " + mesesExtenso[mes - 1] + " de " + ano;
    }
    
    public String toSimpleString() {
    	return dia + "/" + mes + "/" + ano;
    }

    public static Data today(){
        Calendar c = new GregorianCalendar();
        return new Data(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
    }

}
