package aula13.ex3.e;

import java.util.*;

public class ListaEmpregados extends LinkedList<Empregado> {

    public ListaEmpregados() {
        super();
    }

    public Empregado serve(){
        Empregado e = super.remove();
        super.add(e);
        return e;
    }

    public String toString(){
        String res = "Lista de empregados:\n";
        Empregado[] arr = super.toArray(new Empregado[super.size()]);
        Arrays.sort(arr, Comparator.comparing(Empregado::getId));
        for(int i = 1; i <= super.size(); i++) {
            res += arr[i - 1] + "\n";
        }
        return res;
    }
}
