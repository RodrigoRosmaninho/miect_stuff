package aula12.ex3.plugins;

import aula12.ex3.*;

import java.io.PrintWriter;
import java.util.Scanner;

public class csv implements FilePlugin {
    @Override
    public Agenda loadFile(Scanner scf, Agenda agenda) {
        while(scf.hasNextLine()) {
            String[] pessoa = scf.nextLine().split("\t");
            if (pessoa.length == 3) {
                String nome = pessoa[0];
                int cc = Integer.parseInt(pessoa[1]);
                String d = pessoa[2];
                Data data = Ficheiro.verificarInfo(agenda,nome,cc,d);
                agenda.addPessoa(nome, cc, data);
            } else {
                throw new IllegalArgumentException("Formato inválido!");
            }
        }
        scf.close();
        return agenda;
    }

    @Override
    public void saveFile(PrintWriter pwf, Agenda agenda) {
        pwf.print("CSV");
        for(Pessoa p : agenda.getDB()) pwf.printf("%n%s\t%d\t%s", p.getNome(), p.getCC(), p.getDataNasc().toSimpleString());
    }
}
