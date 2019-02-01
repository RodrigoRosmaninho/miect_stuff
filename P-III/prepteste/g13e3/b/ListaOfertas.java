package prepteste.g13e3.b;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaOfertas extends ArrayList<Oferta> {
    public ListaOfertas() {
        super();
    }

    @Override
    public String toString() {
        String lista = "";
        Iterator it = super.iterator();
        while(it.hasNext()) lista += "\n" + it.next().toString();
        return "Lista de Ofertas: " + lista;
    }
}
