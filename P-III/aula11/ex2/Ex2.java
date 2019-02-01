package aula11.ex2;

import java.util.ArrayList;
import java.util.List;

public class Ex2 {
    public static void main(String[] args){
        List<Figura> lista = new ArrayList<Figura>();
        lista.add(new Circulo(2));
        lista.add(new Circulo(1, 3, 1));
        lista.add(new Quadrado(5));
        lista.add(new Quadrado(3, 4, 2));
        lista.add(new Retangulo(2, 3));
        lista.add(new Retangulo(3, 4, 5, 3));
        lista.add(new Retangulo(1, 1, 5, 6));

        System.out.printf("Maior Figura (por Área): %s%n", maiorFiguraAreaJ8(lista));
        System.out.printf("Maior Figura (por Perímetro): %s%n", maiorFiguraPerimetroJ8(lista));
        System.out.printf("Área Total das Figuras: %s%n", areaTotalJ8(lista));
        System.out.printf("Área Total dos Retângulos: %s%n", areaTotalJ8(lista, "aula11.ex2.Retangulo"));
    }

    private static Figura maiorFiguraAreaJ8(List<Figura> figs){
        return figs.stream().max(Figura::compareTo).get();
    }

    private static Figura maiorFiguraPerimetroJ8(List<Figura> figs){
        return figs.stream().max((f1, f2) -> (int) (f1.getPerimetro() - f2.getPerimetro())).get();
    }

    private static double areaTotalJ8(List<Figura> figs) {
        return figs.stream().mapToDouble(Figura::getArea).sum();
    }

    private static double areaTotalJ8(List<Figura> figs, String subtipoNome) {
        return figs.stream().filter((f1) -> f1.getClass().toString().equals("class " + subtipoNome)).mapToDouble(Figura::getArea).sum();
    }
}
