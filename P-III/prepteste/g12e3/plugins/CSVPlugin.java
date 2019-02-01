package prepteste.g12e3.plugins;

import prepteste.g12e3.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class CSVPlugin implements IPlugin {
    @Override
    public void saveFile(Agenda agenda, String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("CSV\n");
        for (Pessoa p : agenda.getDB()) {
            bw.write(p.getNome());
            bw.write("\t" + p.getCC());
            bw.write("\t" + p.getDataNasc().toSimpleString());
            bw.newLine();
        }
        bw.close(); fw.close();
    }

    @Override
    public Agenda loadFile(Agenda agenda, Iterator<String> it) throws IOException {
        while(it.hasNext()){
            String[] line = it.next().split("\t");
            if(line.length != 3) throw new IllegalArgumentException("Formato inválido!");
            Data DataNasc = Ficheiro.verificarInfo(agenda, line[0], Integer.parseInt(line[1]), line[2]);
            agenda.addPessoa(line[0], Integer.parseInt(line[1]), DataNasc);
        }
        return agenda;
    }
}