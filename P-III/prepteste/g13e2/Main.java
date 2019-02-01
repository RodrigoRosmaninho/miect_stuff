package prepteste.g13e2;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, Palavra> palavras = new HashMap<>();
        List<String> list = Files.readAllLines(Paths.get("../P-III/src/prepteste/g13e2/Policarpo.txt"))
                .stream()
                .flatMap((str) -> Arrays.stream(str.trim().split(" |\t|\n|\\.|,|:|\'|‘|’|;|\\?|!|-|\\*|\\{|}|=|\\+|&|/|\\(|\\)|[|]|”|“|\"|\'")))
                .filter((str) -> str.length() >= 3)
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        FileWriter fw = new FileWriter("../P-III/src/prepteste/g13e2/output.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        for(int i = 0; i < list.size() - 1; i++) {
            String s = list.get(i);
            Palavra p = palavras.get(s);
            if(p == null) {
                p = new Palavra(s);
                palavras.put(s,p);
            }
            p.addPar(list.get(i+1));
        }


        List<Palavra> finalList = palavras.values().stream().sorted(Comparator.comparing(Palavra::getPalavra)).collect(Collectors.toList());
        finalList.forEach(System.out::println);
        finalList.forEach((v) -> {
            try {
                bw.write(v.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        bw.close(); fw.close();
    }
}
