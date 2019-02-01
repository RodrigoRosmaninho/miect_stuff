package aula9.ex1;

import java.io.File;
import java.io.FileNotFoundException;

public class Ex1 {
    public static void main(String[] args) throws FileNotFoundException {
        ScannerAbeirense sc = new ScannerAbeirense(System.in);
        ScannerAbeirense scf = new ScannerAbeirense(new File("aula9/ex1/TestFile.txt"));

        System.out.print("Qual o seu nome? ");
        String nome = sc.nextLine();
        System.out.println("Olá " + nome + "!");

        System.out.print("\nAgora só um carater: ");
        String c= sc.next();
        System.out.println("Inseriu: " + c);

        System.out.println("\n--- Leitura de ficheiro ---\n");

        while(scf.hasNext()){
            System.out.println(scf.nextLine());
        }
    }
}
