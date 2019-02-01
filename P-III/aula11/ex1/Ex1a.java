package aula11.ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class Ex1a {
    public static void main(String[] args) {

        ArrayList<Pessoa> vp = new ArrayList<>();
        for (int i=0; i<10; i++)
            vp.add(new Pessoa("Bebé no Vetor "+i,
                    1000+i, Data.today()));

        Iterator<Pessoa> vec = vp.iterator();
        printSet(vp.iterator());

        LinkedList<Pessoa> lp = new LinkedList<>();
        while ( vec.hasNext() )
            lp.add( vec.next() );

        Iterator<Pessoa> lista = lp.iterator();
        while ( lista.hasNext() )
            System.out.println( lista.next() );

        LinkedList<Figura> figList = new LinkedList<>();
        figList.add(new Circulo (1,3, 1));
        figList.add(new Quadrado(3,4, 2));
        figList.add(new Retangulo(1,2, 2,5));
        printSet(figList.iterator());
        System.out.println("Soma da Area de Lista de Figuras: " +
                sumArea(figList));

        // Partindo do principio que Quadrado extends Retangulo:
        LinkedList< Retangulo > quadList =
                new LinkedList<>();
        quadList.add(new Quadrado(3,4, 2));
        quadList.add(new Retangulo(1,2, 2,5));

        System.out.println("Soma da Area de Lista de Quadrados: " +
                sumArea(quadList));
    }

    public static double sumArea(LinkedList<? extends Figura> figuras){
        double res = 0.0;

        Iterator i = figuras.iterator();
        while(i.hasNext()) res += ((Figura) i.next()).getArea();

        return res;
    }

    public static void printSet(Iterator i){
        while(i.hasNext()) System.out.println(i.next());
    }
}
