package aula11.ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex1e_b {
    public static void main(String[] args) throws IOException {
        List<String> words =
                Files.readAllLines(Paths.get("aula11/ex1/Ex1b.java"))
                        .stream()
                        .flatMap((str) -> Arrays.stream(str.trim().split(" ")))
                        .filter((str) -> str.length() > 0)
                        .collect(Collectors.toList());

        System.out.printf("Número Total de Palavras: %d%n", words.size());
        System.out.printf("Número de Palavras Distintas: %d%n", words.stream().distinct().count());
    }
}
