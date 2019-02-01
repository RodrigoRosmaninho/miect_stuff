package aula13.ex3.d;

import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args){
        Empregado e1 = new Empregado("Rodrigo", "Rosmaninho", 1);

        List<Empregado> empregados = new ArrayList<>();
        empregados.add(e1);
        empregados.add(e1);
        empregados.add(new Empregado("Paulo", "Ferreira", 2));
        empregados.add(new Empregado("Nuno", "Carvalho", 3));
        empregados.add(new Empregado("Joaquim", "Madeira", 4));
        empregados.add(new Empregado("Arnaldo", "Oliveira", 5));
        empregados.add(new Empregado("Carlos", "Costa", 6));

        ListaNomes nomes = new ListaNomes();
        empregados.stream().forEach(nomes::add);
        System.out.println(nomes);
        nomes.remove(e1);
        System.out.println(nomes);
        nomes.remove(e1);
        System.out.println(nomes);
    }
}
