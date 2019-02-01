package aula13.ex3.d;

import java.util.Arrays;
import java.util.HashMap;

public class ListaNomes extends HashMap<String, Integer> {
    public ListaNomes() {
        super();
    }

    public void add(Empregado e){
        super.merge(e.getPrimeiro_nome(), 1, (k, v) -> v + 1);
    }

    public void remove(Empregado e){
        super.computeIfPresent(e.getPrimeiro_nome(), (k,v) -> {
            if(v == 1) return null;
            else return v - 1;
        });
    }

    public String toString(){
        String res = "Lista de nomes:\n";
        Entry<String, Integer>[] arr = super.entrySet().toArray(new Entry[super.size()]);
        Arrays.sort(arr, (e1, e2) -> e2.getValue() - e1.getValue());
        int i = 1;
        while(i <= super.size()){
            Entry e = arr[i - 1];
            res +=  e.getKey() + "\t" + e.getValue() + "\n";
            i++;
        }
        return res;
    }
}


