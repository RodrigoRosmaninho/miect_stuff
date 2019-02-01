package prepteste.g12e3;

import java.io.IOException;
import java.util.Iterator;

public interface IPlugin {
    void saveFile(Agenda agenda, String path) throws IOException;
    Agenda loadFile(Agenda agenda, Iterator<String> it) throws IOException;
}
