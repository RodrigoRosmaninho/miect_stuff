package prepteste.g13e2;

import java.util.LinkedHashMap;

public class Palavra {
    String palavra;
    LinkedHashMap<String, Integer> pares;

    public Palavra(String palavra) {
        this.palavra = palavra;
        pares = new LinkedHashMap<>();
    }

    public String getPalavra() {
        return palavra;
    }

    public void addPar(String p){
        pares.merge(p,1, (k, v) -> v + 1);
    }

    @Override
    public String toString() {
        return palavra + "=" +
                pares.toString();
    }
}
