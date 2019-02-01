package aula11.ex1;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class Ex1b {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("aula11/ex1/Ex1b.java");
        Scanner sc = new Scanner(file);
        int count = 0;
        HashSet<String> set = new HashSet<>();
        sc.useDelimiter("\\s+");
        while(sc.hasNext()){
            set.add(sc.next());
            count++;
        }

        System.out.printf("Número Total de Palavras: %d%n", count);
        System.out.printf("Número de Palavras Distintas: %d%n", set.size());
    }
}
