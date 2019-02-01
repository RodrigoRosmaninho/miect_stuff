package aula6.ex2;

import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.List;

public interface ListsProcess{
    public static <T> List<T> filter(List<T> lista, Predicate<T> p){
        List<T> tmp = new ArrayList<T>();
        for(T t : lista) if(p.test(t)) tmp.add(t);
        return tmp; 
    }
}