package aula12.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

abstract class PluginManager {
    public static FilePlugin load(String name) throws Exception {
        Class<?> c = Class. forName (name);
        return (FilePlugin) c.newInstance();
    }
}

public abstract class Ficheiro {

	public static Agenda load(File f, Agenda agenda) throws FileNotFoundException {
		if(!(f.exists() && f.isFile() && f.canRead())) throw new IllegalArgumentException("Ficheiro não existe ou não pode ser lido!");
		Scanner scf = new Scanner(f);
		try {
            FilePlugin plugin = PluginManager.load("aula12.ex3.plugins." + scf.nextLine().toLowerCase());
            Agenda a = plugin.loadFile(scf, agenda);
            scf.close();
            return a;
        } catch(ClassNotFoundException cnfe) {
			scf.close();
			throw new IllegalArgumentException("Formato desconhecido!");
		} catch (Exception e) {
            e.printStackTrace();
        }
		return null;
    }
	
	public static Data verificarInfo(Agenda agenda, String nome, int cc, String data) {
		Data d;
		if (nome.length() == 0) throw new IllegalArgumentException("Nome inválido detetado! Verificar Formato!");
		if (cc < 0) throw new IllegalArgumentException("Cartão de cidadão inválido!");
		if (agenda.containsPessoa(cc)) throw new IllegalArgumentException("Existem pessoas com o mesmo CC!");
		String[] dataArr = data.split("/");
        if (dataArr.length == 3) {
            try {
                d = new Data(Integer.parseInt(dataArr[0]), Integer.parseInt(dataArr[1]), Integer.parseInt(dataArr[2]));
            } catch (NumberFormatException nfe) {
                throw new NumberFormatException("A data só pode conter algarismos e o delimitador!");
            }
        } else {
            throw new IllegalArgumentException("Formato de data inválido!");
        }
        return d;
	}
	
	public static void save(File f, Agenda agenda, String formato) throws FileNotFoundException {
		if(f.exists() && !(f.isFile() && f.canWrite())) throw new IllegalArgumentException("Ficheiro não pode ser escrito!");
		PrintWriter pwf = new PrintWriter(f);
        try {
            FilePlugin plugin = PluginManager.load("aula12.ex3.plugins." + formato.toLowerCase());
            plugin.saveFile(pwf, agenda);
            pwf.close();
        } catch(ClassNotFoundException cnfe) {
            pwf.close();
            throw new IllegalArgumentException("Formato desconhecido!");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
