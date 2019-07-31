import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.*;
import java.nio.file.Files;
import java.io.IOException;

public class CustomListener extends ex4BaseListener {
    HashMap<String, Integer> hm = new HashMap<>();

    public void enterProgram(ex4Parser.ProgramContext ctx) {
        try {
            Files.readAllLines(Paths.get("numbers.txt")).forEach(l -> {
                String[] arr = l.split(" - ");
                hm.put(arr[1], Integer.parseInt(arr[0]));
            });
        } catch (IOException ioe) {

        }
    }

    public void enterNumber(ex4Parser.NumberContext ctx) {
        String[] words = ctx.NUM().toString().split("-");
        int result = 0;
        try {
            for(String word : words) result += hm.get(word);
        } catch (NullPointerException npe) {
        }
        System.out.print(result + " ");
    }
}