package prepteste.g11e1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class e_d {
    public static void main(String[] args) throws IOException {
        Files.readAllLines(Paths.get("../P-III/src/prepteste/g13e2/Policarpo.txt"))
                .stream()
                .flatMap(str -> Arrays.stream(str.trim().split(" ")))
                .filter(str -> str.length() > 0)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .collect(Collectors.toList())
                .forEach(e -> System.out.printf("%20s %3d%n", e.getKey(), e.getValue()));
    }
}
