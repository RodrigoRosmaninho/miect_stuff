package aula12.ex1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class ReflectionTools {
    List<Object> objects;

    public ReflectionTools() {
        objects = new ArrayList<>();
    }

    public List<Object> getObjects() {
        return objects;
    }

    public String add(Object o)  {
        objects.add(o);
        return o.toString();
    }

    public Object newInstance(Class<?> cls, int constructorIndex, Object[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return cls.getConstructors()[constructorIndex - 1].newInstance(args);
    }

    public String getConstructors(Class<?> cls){
        String res = "";
        Constructor[] c = cls.getConstructors();
        for(int k = 0; k < c.length; k++) res += (k + 1) + " - " + ClassDumper.parseConstructor(c[k]) + "\n";
        return res;
    }

    public Parameter[] getConstructorParams(Class<?> cls, int constructorIndex){
        Constructor c = cls.getConstructors()[constructorIndex - 1];
        return c.getParameters();
    }

    public Parameter[] getMethodParams(int objectIndex, int methodIndex){
        Class<?> cls = objects.get(objectIndex - 1).getClass();
        Method m = cls.getDeclaredMethods()[methodIndex - 1];
        return m.getParameters();
    }

    public String getMethods(int i){
        Class<?> cls = objects.get(i - 1).getClass();
        String res = "";
        Method[] m = cls.getDeclaredMethods();
        for(int k = 0; k < m.length; k++) res += (k + 1) + " - " + ClassDumper.parseMethod(m[k]) + "\n";
        return res;
    }

    public Object callMethod(int objectIndex, int methodIndex, Object[] args) throws InvocationTargetException, IllegalAccessException {
        Class<?> cls = objects.get(objectIndex - 1).getClass();
        Method m = cls.getMethods()[methodIndex - 1];
        return m.invoke(objects.get(objectIndex - 1),args);
    }

    public String list() {
        String res = "";
        for(int i = 0; i < objects.size(); i++) res += (i + 1) + " - " + objects.get(i).toString() + "\n";
        return res;
    }

    @Override
    public String toString() {
        return "ReflectionTools com lista de tamanho: " + objects.size();
    }
}
