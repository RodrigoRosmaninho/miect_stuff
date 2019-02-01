package aula4.ex1;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public static int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Data(int dia, int mes, int ano) throws DateValidationException{
        if(data_valida(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }
        else{
            throw new DateValidationException();
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

    @Override
    public String toString(){
        return dia + "/" + mes + "/" + ano;
    }

}
