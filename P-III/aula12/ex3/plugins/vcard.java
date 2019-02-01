package aula12.ex3.plugins;

import aula12.ex3.*;

import java.io.PrintWriter;
import java.util.Scanner;

public class vcard implements FilePlugin {
    @Override
    public Agenda loadFile(Scanner scf, Agenda agenda) {
        while(scf.hasNextLine()) {
            String[] pessoa = scf.nextLine().split("#");
            if (pessoa.length == 4) {
                String nome = pessoa[1];
                int cc = Integer.parseInt(pessoa[2]);
                String d = pessoa[3];
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
        pwf.print("vCard");
        for(Pessoa p : agenda.getDB()) pwf.printf("%n#%s#%d#%s", p.getNome(), p.getCC(), p.getDataNasc().toSimpleString());
    }
}
