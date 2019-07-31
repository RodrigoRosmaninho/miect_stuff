import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.*;
import java.nio.file.Files;
import java.io.IOException;

public class g1e6c {
    public static void main(String[] args) throws IOException{
        HashMap<String, String> hm = new HashMap<>();
        Files.readAllLines(Paths.get(args[0])).forEach(l -> {
            String[] tmp = l.split(" ");
            String[] arr = Arrays.copyOfRange(tmp, 1, tmp.length);
            hm.put(tmp[0], String.join(" ", arr));
        });

        for(int i = 1; i < args.length; i++){
            Files.readAllLines(Paths.get(args[i])).forEach(l -> {

                boolean houveTrocas = true;
                while(houveTrocas) {
                    String[] line = l.split(" ");
                    houveTrocas = false;
                    for(int j = 0; j < line.length; j++) {
                        String s = hm.get(line[j]);
                        if(s != null) {
                            houveTrocas = true;
                            line[j] = s.trim();
                        }
                    }
                    l = String.join(" ", line);
                }
                System.out.println(l);
            });
            System.out.println();
        }
    }
}