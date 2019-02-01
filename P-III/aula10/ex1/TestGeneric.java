package aula10.ex1;

import java.util.Iterator;

public abstract class TestGeneric {
    public static void main(String[] args) {

        VetorGeneric<Pessoa> vp = new VetorGeneric<>();
        for (int i=0; i<10; i++)
            vp.addElem(new Pessoa("Bebé no Vetor "+i,
                    1000+i, Data.today()));

        Iterator<Pessoa> vec = vp.iterator();
        printSet(vp.iterator());

        ListaGeneric<Pessoa> lp = new ListaGeneric<>();
        while ( vec.hasNext() )
            lp.addElem( vec.next() );

        Iterator<Pessoa> lista = lp.iterator();
        while ( lista.hasNext() )
            System.out.println( lista.next() );

        ListaGeneric<Figura> figList = new ListaGeneric<>();
        figList.addElem(new Circulo (1,3, 1));
        figList.addElem(new Quadrado(3,4, 2));
        figList.addElem(new Retangulo(1,2, 2,5));
        printSet(figList.iterator());
        System.out.println("Soma da Area de Lista de Figuras: " +
                sumArea(figList));

        // Partindo do principio que Quadrado extends Retangulo:
        ListaGeneric< Retangulo > quadList =
                new ListaGeneric<>();
        quadList.addElem(new Quadrado(3,4, 2));
        quadList.addElem(new Retangulo(1,2, 2,5));

        System.out.println("Soma da Area de Lista de Quadrados: " +
                sumArea(quadList));
    }

    public static double sumArea(ListaGeneric<? extends Figura> figuras){
        double res = 0.0;

        Iterator i = figuras.iterator();
        while(i.hasNext()) res += ((Figura) i.next()).getArea();

        return res;
    }

    public static void printSet(Iterator i){
        while(i.hasNext()) System.out.println(i.next());
    }
}
