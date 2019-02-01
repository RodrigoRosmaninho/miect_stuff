package aula11.ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Ex1e_d {
    public static void main(String[] args) throws IOException {
        new TreeMap<>(
                Files.readAllLines(Paths.get("aula11/ex1/Ex1d.java"))
                .stream()
                .flatMap((str) -> Arrays.stream(str.trim().split(" ")))
                .filter((str) -> str.length() > 0)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
        ).forEach((k, v) -> System.out.printf("%20s %10d%n", k, v));

    }
}
