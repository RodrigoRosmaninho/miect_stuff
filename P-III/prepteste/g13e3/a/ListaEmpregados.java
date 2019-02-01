package prepteste.g13e3.a;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaEmpregados extends ArrayList<Empregado> {
    public ListaEmpregados() {
        super();
    }

    public boolean add(String s){
        return super.add(new Empregado(s, super.size() + 1));
    }

    @Override
    public String toString() {
        String lista = "";
        Iterator it = super.iterator();
        while(it.hasNext()) lista += "\n" + it.next().toString();
        return "Lista de Empregados: " + lista;
    }
}
