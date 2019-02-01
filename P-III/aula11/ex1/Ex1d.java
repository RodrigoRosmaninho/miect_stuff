package aula11.ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex1d {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("aula11/ex1/Ex1d.java");
        Scanner sc = new Scanner(file);

        TreeMap<String, Integer> map = new TreeMap<>();
        // Usar a comparação natural entre Strings

        sc.useDelimiter("\\s+");
        while(sc.hasNext()){
            String s = sc.next();
            int n = 1;

            if(map.containsKey(s)) n= map.get(s) + 1;
            map.put(s, n);
        }

        for(String s : map.keySet()){
            System.out.printf("%20s %10d%n", s, map.get(s));
        }
    }
}
