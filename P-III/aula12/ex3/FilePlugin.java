package aula12.ex3;

import java.io.PrintWriter;
import java.util.Scanner;

public interface FilePlugin {
    Agenda loadFile(Scanner scf, Agenda agenda);
    void saveFile(PrintWriter pwf, Agenda agenda);
}
