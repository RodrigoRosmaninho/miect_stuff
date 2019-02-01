package aula13.ex2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Ex2 {
    public static void main(String[] args) throws IOException {
        HashMap<String, Palavra> palavras = new HashMap<>();
        List<String> list = Files.readAllLines(Paths.get("aula13/ex2/Policarpo.txt"))
                .stream()
                .flatMap((str) -> Arrays.stream(str.trim().split("( |\n|\t|\\.|,|:|‘|’|;|\\?|!|-|\\*|\\{|}|=|\\+|&|/|\\(|\\)|[|]|”|“|\\|\"|\')")))
                .filter((str) -> str.length() >= 3)
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        for(int i = 0; i < list.size() - 1; i++) {
            String s = list.get(i);
            Palavra p = palavras.get(s);
            if(p == null) {
                p = new Palavra(s);
                palavras.put(s, p);
            }
            p.addPar(list.get(i + 1));
        }

        File f = new File("aula13/ex2/output.txt");
        PrintWriter pw = new PrintWriter(f);

        Palavra[] final_list = palavras.values().toArray(new Palavra[palavras.size()]);
        Arrays.sort(final_list, Comparator.comparing(Palavra::getPalavra));
        Arrays.stream(final_list).forEach(System.out::println);
        Arrays.stream(final_list).forEach(pw::println);

        pw.close();
    }
}
