package aula12.ex3.plugins;

import aula12.ex3.*;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class nokia implements FilePlugin {
    @Override
    public Agenda loadFile(Scanner scf, Agenda agenda) {
        while(scf.hasNextLine()) {
            String nome = scf.nextLine();
            int cc = scf.nextInt();
            scf.nextLine();
            String d = scf.nextLine();
            Data data = Ficheiro.verificarInfo(agenda,nome,cc,d);
            agenda.addPessoa(nome, cc, data);
            if(scf.hasNextLine()) scf.nextLine();
        }
        scf.close();
        return agenda;
    }

    @Override
    public void saveFile(PrintWriter pwf, Agenda agenda) {
        pwf.print("Nokia");
        ArrayList<Pessoa> lista = agenda.getDB();
        for(int i = 0; i < lista.size(); i++) {
            if(i != 0) pwf.println();
            pwf.printf("%n%s%n%d%n%s", lista.get(i).getNome(), lista.get(i).getCC(), lista.get(i).getDataNasc().toSimpleString());
        }
    }
}
