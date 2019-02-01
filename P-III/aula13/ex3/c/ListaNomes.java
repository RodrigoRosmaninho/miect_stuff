package aula13.ex3.c;

import java.util.HashSet;
import java.util.Iterator;

public class ListaNomes extends HashSet<String> {
    public ListaNomes() {
        super();
    }

    public boolean add(Empregado e){
        return super.add(e.getPrimeiro_nome());
    }

    public void remove(Empregado e){
        super.removeIf(s -> s.equals(e.getPrimeiro_nome()));
    }

    public String toString(){
        String res = "Lista de nomes:\n";
        Iterator it = super.iterator();
        int i = 1;
        while(it.hasNext()){
            res += it.next() + "\n";
            i++;
        }
        return res;
    }
}
