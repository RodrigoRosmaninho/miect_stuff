package aula12.ex2.plugins;

import aula12.ex2.IPlugin;

public class SystemProperties implements IPlugin {
    @Override
    public void fazQualQuerCoisa() {
        System.getProperties().list(System.out);
    }
}
