package aula11.ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Ex1c {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("aula11/ex1/Ex1c.java");
        Scanner sc = new Scanner(file);

        HashMap<String, Integer> map = new HashMap<>();
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
