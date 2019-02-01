package aula7.ex1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Ex1 {
    static ArrayList<Voo> voos;
    static HashMap<String, Cidade> cidades;
    static HashMap<String, Companhia> companhias;

    public static void main(String[] args) throws IOException {
        voos = new ArrayList<>();
        cidades = new HashMap<>();
        companhias = new HashMap<>();

        try {
            readCompanhias();
            readVoos();

            Collections.sort(voos);
            File f = new File("aula7/ex1/Infopublico.txt");
            PrintWriter pwf = new PrintWriter(f);
            System.out.println("Hora\tVoo\tCompanhia\tOrigem\tAtraso\tObs");
            pwf.println("Hora\tVoo\tCompanhia\tOrigem\tAtraso\tObs");
            for (Voo v : voos) {
                System.out.println(v);
                pwf.println(v);
            }
            pwf.close();

            pwf.println();

            ArrayList<Companhia> l = new ArrayList(companhias.values());
            Collections.sort(l);
            System.out.println("\n\nCompanhia\tAtraso Médio");
            for (Companhia c : l) System.out.println(c);

            ArrayList<Cidade> l2 = new ArrayList(cidades.values());
            Collections.sort(l2);
            f = new File("aula7/ex1/cidades.txt");
            pwf = new PrintWriter(f);
            System.out.println("\n\nOrigem\tVoos");
            pwf.println("\n\nOrigem\tVoos");
            for (Cidade c : l2) {
                System.out.println(c);
                pwf.println(c);
            }
            pwf.close();

        } catch (Exception e){
            System.out.println("****** Erro! " + e.getMessage() + " ******");
            System.exit(1);
        }


    }

    public static void readCompanhias() throws IOException {
        List<String> res = Files.readAllLines(Paths.get("aula7/ex1/companhias.txt"));
        for(String s : res){
            String[] split = s.split("\t");
            if(split[0].length() == 2) companhias.put(split[0], new Companhia(split[1], split[0]));
        }
    }

    public static void readVoos() throws IOException{
        List<String> res = Files.readAllLines(Paths.get("aula7/ex1/voos.txt"));
        for(String s : res){
            String[] split = s.split("\t");
            if(split[0].length() == 5) {
                if(split.length == 3) voos.add(new Voo(new Hora(split[0]), split[1], getCompanhia(split[1].substring(0,2)), getCidade(split[2]), null));
                else voos.add(new Voo(new Hora(split[0]), split[1], getCompanhia(split[1].substring(0,2)), getCidade(split[2]), new Hora(split[3])));
            }
        }
    }

    public static Cidade getCidade(String nome){
        if(cidades.containsKey(nome)) return cidades.get(nome);
        Cidade c = new Cidade(nome);
        cidades.put(nome, c);
        return c;
    }

    public static Companhia getCompanhia(String sigla){
        if(companhias.containsKey(sigla)) return companhias.get(sigla);
        return new Companhia(sigla, sigla);
    }

}
