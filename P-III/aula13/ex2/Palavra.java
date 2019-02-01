package aula13.ex2;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Palavra {
    private String palavra;
    private LinkedHashMap<String, Integer> pares;

    public Palavra(String palavra) {
        this.palavra = palavra;
        pares = new LinkedHashMap<>();
    }

    public String getPalavra() {
        return palavra;
    }

    public LinkedHashMap<String, Integer> getPares() {
        return pares;
    }

    public void addPar(String s){
        pares.merge(s,1, (k,v) -> v + 1);
    }

    public String toString(){
        String res = palavra + "={";
        Iterator it = pares.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Integer> e = (Map.Entry) it.next();
            res += e.getKey() + "=" + e.getValue() + ", ";
        }
        return res.substring(0,res.length() - 2) + "}";
    }
}
