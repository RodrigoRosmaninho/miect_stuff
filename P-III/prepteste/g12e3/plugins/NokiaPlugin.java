package prepteste.g12e3.plugins;

import prepteste.g12e3.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class NokiaPlugin implements IPlugin {
    @Override
    public void saveFile(Agenda agenda, String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Nokia\n");
        for (Pessoa p : agenda.getDB()) {
            bw.write(p.getNome() + "\n");
            bw.write(p.getCC() + "\n");
            bw.write(p.getDataNasc().toSimpleString() + "\n");
            bw.newLine();
        }
        bw.close(); fw.close();
    }

    @Override
    public Agenda loadFile(Agenda agenda, Iterator<String> it) throws IOException {
        while(it.hasNext()){
            String nome = it.next();
            int CC = Integer.parseInt(it.next());
            Data DataNasc = Ficheiro.verificarInfo(agenda, nome, CC, it.next());
            agenda.addPessoa(nome, CC, DataNasc);
            if(it.hasNext()) it.next();
        }
        return agenda;
    }
}