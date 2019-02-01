package aula13.ex3.a;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaEmpregados extends ArrayList<Empregado> {
    public ListaEmpregados() {
        super();
    }

    public boolean add(String s){
        return super.add(new Empregado(s, size() + 1));
    }

    public String toString(){
        String res = "Lista de empregados:\n";
        Iterator it = super.iterator();
        int i = 1;
        while(it.hasNext()){
            res += it.next() + "\n";
            i++;
        }
        return res;
    }
}
