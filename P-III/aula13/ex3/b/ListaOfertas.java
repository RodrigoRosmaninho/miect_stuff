package aula13.ex3.b;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaOfertas extends ArrayList<Oferta> {
    public ListaOfertas() {
        super();
    }

    public boolean add(Empregado e, Brinquedo b){
        return super.add(new Oferta(e, b,size() + 1));
    }

    public String toString(){
        String res = "Lista de ofertas:\n";
        Iterator it = super.iterator();
        int i = 1;
        while(it.hasNext()){
            res += it.next() + "\n";
            i++;
        }
        return res;
    }
}
