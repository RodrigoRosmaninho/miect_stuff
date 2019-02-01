package aula12.ex1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public abstract class ClassDumper {

    public static Class<?> readClass(String name) throws ClassNotFoundException {
        Class<?> cls = Class.forName(name);
        System.out.println("\n" + parseModifiers(cls) + cls.getSimpleName() + " " + parseInheritance(cls));
        Arrays.stream(cls.getDeclaredFields()).forEach(f -> System.out.println("\t" + parseField(f)));
        System.out.println();
        Arrays.stream(cls.getConstructors()).forEach(c -> System.out.println("\t" + parseConstructor(c)));
        System.out.println();
        Arrays.stream(cls.getDeclaredMethods()).forEach(m -> System.out.println("\t" + parseMethod(m)));
        return cls;
    }

    private static String parseModifiers(Class<?> cls){
        int m = cls.getModifiers();
        String res = parseModifiers(m);

        if(Modifier.isInterface(m)) res += "interface ";
        else res += "class ";
        return res;
    }

    private static String parseModifiers(int m){
        String res = "";

        if(Modifier.isPublic(m)) res += "public ";
        else if(Modifier.isPrivate(m)) res += "private ";
        else if(Modifier.isProtected(m)) res += "protected ";

        if(Modifier.isAbstract(m)) res += "abstract ";
        else if(Modifier.isStatic(m)) res += "static ";

        if(Modifier.isFinal(m)) res += "final ";

        if(Modifier.isNative(m)) res += "native ";
        if(Modifier.isVolatile(m)) res += "volatile ";
        if(Modifier.isStrict(m)) res += "srict ";
        if(Modifier.isSynchronized(m)) res += "synchronized ";
        if(Modifier.isTransient(m)) res += "transient ";

        return res;
    }

    private static String parseInheritance(Class<?> cls){
        String res = "";

        Class<?> sup = cls.getSuperclass();
        if(sup != null) res += "extends " + sup.getSimpleName() + " ";

        Class<?>[] itf = cls.getInterfaces();
        if(itf.length > 0) {
            res += "implements ";
            for (int i = 0; i < itf.length; i++) {
                if(i == 0) res += itf[i].getSimpleName();
                else res += ", " + itf[i].getSimpleName();
            }
        }

        return res;
    }

    private static String parseField(Field f){
        String res = "";

        res += parseModifiers(f.getModifiers());
        res += f.getType().getSimpleName() + " ";
        res += f.getName();

        return res;
    }

    public static String parseConstructor(Constructor c){
        String res = "";

        res += parseModifiers(c.getModifiers());
        res += c.getDeclaringClass().getSimpleName() + "(";
        res += parseParameters(c.getParameterTypes()) + ")";

        return res;
    }

    public static String parseMethod(Method m){
        String res = "";

        res += parseModifiers(m.getModifiers());
        res += m.getReturnType().getSimpleName() + " ";
        res += m.getName() + "(";
        res += parseParameters(m.getParameterTypes()) + ")";

        return res;
    }

    private static String parseParameters(Class<?>[] params){
        String res = "";

        for(int i = 0; i < params.length; i++) {
            if(i == params.length - 1) res += params[i].getSimpleName() + " param" + (i + 1);
            else res += params[i].getSimpleName() + " param" + (i + 1) + ", ";
        }

        return res;
    }


}
