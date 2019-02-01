package aula13.ex3.e;

import java.util.ArrayList;
import java.util.List;

public class Teste {
    static ListaEmpregados empregados;

    public static void main(String[] args){
        Empregado e1 = new Empregado("Rodrigo", "Rosmaninho", 1);

        empregados = new ListaEmpregados();
        empregados.add(e1);
        empregados.add(new Empregado("Paulo", "Ferreira", 2));
        empregados.add(new Empregado("Nuno", "Carvalho", 3));
        empregados.add(new Empregado("Joaquim", "Madeira", 4));
        empregados.add(new Empregado("Arnaldo", "Oliveira", 5));
        empregados.add(new Empregado("Carlos", "Costa", 6));

        printList(31);
        empregados.remove(e1);
        printList(31);
    }

    public static void printList(int numBilhetes){
        for(Empregado e : empregados) e.setBilhetes(0);
        for(int i = 0; i < numBilhetes; i++) {
            empregados.serve().incrementBilhetes();
        }
        System.out.println(empregados);
    }
}
