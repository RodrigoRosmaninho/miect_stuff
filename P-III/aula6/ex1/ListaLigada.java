package aula6.ex1;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class ListaLigada<T> extends LinkedList<T> implements Serializable {

    public ListaLigada(){
        super();
    }

    public T getObjFromIndex(int index){
        if(index <= 0 || index > super.size()) throw new IndexOutOfBoundsException("Índice Inválido!");
        if(index == 1) return super.getFirst();
        if(index == super.size()) return super.getLast();
        int i = 1;
        for(Iterator<T> it = super.iterator(); it.hasNext(); i++){
            T t = it.next();
            if(i == index) return t;
        }
        throw new IndexOutOfBoundsException();
    }

    public String toString(){
        Iterator<T> it = super.iterator();
        String res = "";
        int i = 1;
        for(;it.hasNext(); i++){
            res += i + " -> " + it.next().toString();
            if(it.hasNext()) res += "\n";
        }
        return res;
    }

}
