package prepteste.g11e1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class e_c {
    public static void main(String[] args) throws IOException {
        Files.readAllLines(Paths.get("../P-III/src/prepteste/g13e2/Policarpo.txt"))
                .stream()
                .flatMap(str -> Arrays.stream(str.trim().split(" ")))
                .filter(str -> str.length() > 0)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .forEach((k,v) -> System.out.printf("%20s %3d%n", k, v));
    }
}
