package prepteste.g12e3.plugins;

import prepteste.g12e3.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class vCardPlugin implements IPlugin {
    @Override
    public void saveFile(Agenda agenda, String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("vCard\n");
        for (Pessoa p : agenda.getDB()) {
            bw.write("#" + p.getNome());
            bw.write("#" + p.getCC());
            bw.write("#" + p.getDataNasc().toSimpleString());
            bw.newLine();
        }
        bw.close(); fw.close();
    }

    @Override
    public Agenda loadFile(Agenda agenda, Iterator<String> it) throws IOException {
        while(it.hasNext()){
            String[] line = it.next().split("#");
            if(line.length != 4) throw new IllegalArgumentException("Formato inválido!");
            Data DataNasc = Ficheiro.verificarInfo(agenda, line[1], Integer.parseInt(line[2]), line[3]);
            agenda.addPessoa(line[1], Integer.parseInt(line[2]), DataNasc);
        }
        return agenda;
    }
}