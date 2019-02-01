package aula9.ex1;

import java.io.*;
import java.util.Iterator;

public class ScannerAbeirense implements Iterator<String>, Closeable {
    private BufferedInputStream bis;

    public ScannerAbeirense(InputStream stream) {
        bis = new BufferedInputStream(stream);
    }

    public ScannerAbeirense(File f) throws FileNotFoundException {
        bis = new BufferedInputStream(new FileInputStream(f));
    }

    public String nextLine(){
        String res = "";
        String next = next();
        while(!next.equals("\n")){
            res += next;
            next = next();
        }
        return res;
    }

    @Override
    public void close() throws IOException {
        bis.close();
    }

    @Override
    public boolean hasNext() {
        try {
            return bis.available() > 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String next() {
        try {
            int r = bis.read();
            if(r == -1) return "";
            if(r == 'v' | r == 'V') r -= 20 ;
            return "" + (char) r;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
