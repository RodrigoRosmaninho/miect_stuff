import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.*;
import java.nio.file.Files;
import java.io.IOException;

public class g1e6 {
    public static void main(String[] args) throws IOException{
        HashMap<String, String> hm = new HashMap<>();
        Files.readAllLines(Paths.get(args[0])).forEach(l -> {
            String[] tmp = l.split(" ");
            String[] arr = Arrays.copyOfRange(tmp, 1, tmp.length);
            hm.put(tmp[0], String.join(" ", arr));
        });

        for(int i = 1; i < args.length; i++){
            Files.readAllLines(Paths.get(args[i])).forEach(l -> {
                String[] line = l.split(" ");
                for(String w : line) {
                    String s = hm.get(w);
                    if(s != null) w = s;
                    System.out.print(w + " ");
                }
                System.out.println();
            });
            System.out.println();
        }
    }
}