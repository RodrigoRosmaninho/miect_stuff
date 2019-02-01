package prepteste.g11e2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Figura> lista = new ArrayList<Figura>();
        lista.add(new Circulo(2));
        lista.add(new Circulo(1, 3, 1));
        lista.add(new Quadrado(5));
        lista.add(new Quadrado(3, 4, 2));
        lista.add(new Retangulo(2, 3));
        lista.add(new Retangulo(3, 4, 5, 3));
        lista.add(new Retangulo(1, 1, 5, 6));

        System.out.printf("Maior Figura (por Área): %s%n", maiorFigura(lista));
        System.out.printf("Maior Figura (por Perímetro): %s%n", maiorFigura2(lista));
        System.out.printf("Área Total das Figuras: %s%n", areaTotal(lista));
        System.out.printf("Área Total dos Retângulos: %s%n", areaTotal(lista, "Retangulo"));
    }

    private static Figura maiorFigura(List<Figura> figs){
        return figs.stream()
                .max(Figura::compareTo)
                .get();
    }

    private static Figura maiorFigura2(List<Figura> figs){
        return figs.stream()
                .max(Comparator.comparing(Figura::getPerimetro))
                .get();
    }

    private static double areaTotal(List<Figura> figs){
        return figs.stream()
                .mapToDouble(Figura::getArea)
                .sum();
    }

    private static double areaTotal(List<Figura> figs, String subtype){
        return figs.stream()
                .filter(f -> f.getClass().getSimpleName().equals(subtype))
                .mapToDouble(Figura::getArea)
                .sum();
    }
}
