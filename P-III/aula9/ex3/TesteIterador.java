package aula9.ex3;

import java.util.Iterator;

public abstract class TesteIterador {
    public static void main(String[] args) {
        VetorPessoas vp = new VetorPessoas();
        for (int i=0; i<10; i++)
            vp.addPessoa(new Pessoa("Bebé no Vector "+i,
                    1000+i, Data.today()));
        VetorPessoas.VetorIterador vec = vp.iterator();
        while ( vec.hasNext() )
            System.out.println( vec.next() );
        while ( vec.hasPrevious() )
            System.out.println( vec.previous() );
        ListaPessoas lp = new ListaPessoas();
        for (int i=0; i<10; i++)
            lp.addPessoa(new Pessoa("Bebé na Lista "+i,
                    2000+i, Data.today()));
        ListaPessoas.ListaIteradora lista = lp.iterator();
        while ( lista.hasNext() )
            System.out.println( lista.next() );
        while ( lista.hasPrevious() )
            System.out.println( lista.previous() );
    }
}
