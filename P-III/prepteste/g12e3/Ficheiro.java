package prepteste.g12e3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public abstract class Ficheiro {

	private static IPlugin getPlugin(String plugin) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
		return PluginManager.load("prepteste.g12e3.plugins." + plugin + "Plugin");
	}
	
	public static Agenda load(String f, Agenda agenda) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
		Iterator<String> it = Files.readAllLines(Paths.get(f)).iterator();
		return getPlugin(it.next()).loadFile(agenda, it);
	}

	public static void save(String f, Agenda agenda, String format) throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException {
		getPlugin(format).saveFile(agenda, f);
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
}

class PluginManager {
	public static IPlugin load(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		Class<?> c = Class.forName(name);
		return (IPlugin) c.newInstance();
	}
}
