import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.*;
import java.nio.file.Files;
import java.io.IOException;

public class g1e3 {
    public static void main(String[] args) throws IOException{
        HashMap<String, Integer> hm = new HashMap<>();
        Files.readAllLines(Paths.get("numbers.txt")).forEach(l -> {
            String[] arr = l.split(" - ");
            hm.put(arr[1], Integer.parseInt(arr[0]));
        });

        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().trim().split("-| ");
        for(String word : arr){
            try{
                word = Integer.toString(hm.get(word));
            }
            catch(NullPointerException npe){}
            System.out.print(word + " ");
        }
        System.out.println();
    }
}