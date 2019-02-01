package aula12.ex2.plugins;

import aula12.ex2.IPlugin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataAtual implements IPlugin {
    @Override
    public void fazQualQuerCoisa() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println("Data atual -> " + dateFormat.format(date));
    }
}
