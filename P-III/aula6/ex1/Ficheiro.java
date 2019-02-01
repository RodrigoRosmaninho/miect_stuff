package aula6.ex1;

import java.io.*;

public class Ficheiro {

    public static Ementa load(File f) throws IOException, ClassNotFoundException {
        if(!(f.exists() && f.isFile() && f.canRead())) throw new IllegalArgumentException("Ficheiro não existe ou não pode ser lido!");
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Ementa  ementa = (Ementa) ois.readObject();
        return ementa;
    }


    public static void save(File f, Ementa ementa) throws IOException {
        if(f.exists() && !(f.isFile() && f.canWrite())) throw new IllegalArgumentException("Ficheiro não pode ser escrito!");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(ementa);
    }

}
