package prepteste.g11e1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class e_b {
    public static void main(String[] args) throws IOException {
        List<String> lista = Files.readAllLines(Paths.get("../P-III/src/prepteste/g13e2/Policarpo.txt"))
                .stream()
                .flatMap(str -> Arrays.stream(str.trim().split(" ")))
                .collect(Collectors.toList());

        long all = lista.size();

        long distinct = lista.stream()
                .distinct()
                .count();

        System.out.println(all);
        System.out.println(distinct);
    }
}
