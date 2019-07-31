import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.*;
import java.nio.file.Files;
import java.io.IOException;

public class g1e4 {
    public static void main(String[] args) throws IOException{
        HashMap<String, Integer> hm = new HashMap<>();
        Files.readAllLines(Paths.get("numbers.txt")).forEach(l -> {
            String[] arr = l.split(" - ");
            hm.put(arr[1], Integer.parseInt(arr[0]));
        });

        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().trim().split("-| ");
        int res = 0;
        int buffer = -1;
        List<String> valid_words = new ArrayList<>();
        for(String word : arr){
            try{
                int number = hm.get(word);
                if(Math.log10(number) == (int) Math.log10(number)) buffer *= number;
                else {
                    if(buffer != -1) res += buffer;
                    buffer = number;
                }
                valid_words.add(word);
            }
            catch(NullPointerException npe){}
        }
        res += buffer;
        System.out.println(String.join(" ", valid_words) + " -> " + res);
    }
}