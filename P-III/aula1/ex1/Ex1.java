package aula1.ex1;

/*
 * Programação III - Guião Prático 1
 * Rodrigo Rosmaninho, 88802
 * 
 */

import java.util.Scanner;

public class Ex1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("\nIntroduza uma String (':q' para sair): ");
            String string = sc.nextLine();
            if(string.equals(":q")) break;

            System.out.println("Total de carateres numéricos: " + getNumAlgarismos(string));
            System.out.println("A string contem " + getCase(string));
            System.out.print("Palavras lidas: "); getPalavrasLidas(string);
            System.out.println("Carateres trocados 2 a 2: " + getCarateresTrocados(string));

        }
        System.out.println(); // newline
        sc.close();
    }

    public static int getNumAlgarismos(String s){
        int t = 0;
        for(char c : s.toCharArray()) if(Character.isDigit(c)) t++;
        return t;
    }

    public static String getCase(String s) {
        if(s.toUpperCase().equals(s)) return "apenas carateres maiúsculos";
        if(s.toLowerCase().equals(s)) return "apenas carateres minúsculos";
        return "uma mistura de carateres maiúsculos e minúsculos";
    }

    public static void getPalavrasLidas(String s) {
        String[] a = s.split(" ");
        for(String st : a) System.out.print(st + ", ");
        System.out.println(" -> Total: " + a.length);
    }

    public static String getCarateresTrocados(String s) {
        String res = "";
        for(String st : s.split(" ")){
            for (int i = 0; i+1 < st.length(); i=i+2) {
                res += st.charAt(i + 1) + "" + st.charAt(i); 
            }
            if(st.length() % 2 != 0) res += st.charAt(st.length() - 1);
            res += " ";
        }
        return res;
    }
}
