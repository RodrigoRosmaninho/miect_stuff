package aula12.ex1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex1 {
    static Scanner sc;
    static ReflectionTools rf;

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        sc = new Scanner(System.in);
        rf = new ReflectionTools();
        while(true) mostrar_menu();
    }

    public static void mostrar_menu() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        try{
            int escolha;
            System.out.print(""
                    + "\n--------- Menu Geral ---------"
                    + "\n[1] Imprimir estrutura de uma classe"
                    + "\n[2] Ver objetos"
                    + "\n[3] Invocar métodos"
                    + "\n[4] Terminar Programa"
                    + "\nIntroduza a escolha: ");
            try {
                escolha = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("\n****** Erro! Introduziu uma opção inválida! ******");
                sc.nextLine();
                return;
            }
            sc.nextLine();

            switch (escolha) {
                case 1:
                    dump_class();
                    break;
                case 2:
                    print_list();
                    break;
                case 3:
                    call_methods();
                    break;
                case 4:
                    System.out.println(); // newline
                    System.exit(0);
                default:
                    System.out.println("\n****** Erro! Introduziu uma opção inválida! ******");

            }
        } catch(ArrayIndexOutOfBoundsException aioobe){
            System.out.println("*** Erro! Índice inválido! ***");
        } catch(InputMismatchException ime){
            System.out.println("*** Erro! Input Inválido! ***");
        } catch(IllegalArgumentException iae){
            System.out.println("\n*** Erro! Não é instanciável! ***");
        }
    }

    public static void dump_class() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.print("\nIndique a classe a ler: ");
        Class<?> cls = null;
        try {
            cls = ClassDumper.readClass(sc.nextLine());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("*** Erro! Classe não foi encontrada! ***");
            return;
        }

        System.out.print("\nInstanciar novo objeto desta classe (y/n)? ");
        if(sc.nextLine().equalsIgnoreCase("y")) System.out.println(rf.add(newInstance(cls, "")));
    }

    public static Object newInstance(Class<?> cls, String name) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object o;
        if (cls.isPrimitive() || cls.getSimpleName().equalsIgnoreCase("string")) {
            System.out.print(cls.getSimpleName() + " " + name + ": ");
            switch (cls.getSimpleName().toLowerCase()) {
                case "int":
                    o = sc.nextInt();
                    break;
                case "double":
                    o = sc.nextDouble();
                    break;
                case "boolean":
                    o = sc.nextBoolean();
                    break;
                case "byte":
                    o = sc.nextByte();
                    break;
                case "long":
                    o = sc.nextLong();
                    break;
                case "float":
                    o = sc.nextFloat();
                    break;
                case "short":
                    o = sc.nextShort();
                    break;
                case "bigdecimal":
                    o = sc.nextBigDecimal();
                    break;
                case "biginteger":
                    o = sc.nextBigInteger();
                    break;
                case "string":
                    o = sc.nextLine();
                    break;
                default:
                    o = null;
                    break;
            }
        }
        else if(cls.isInterface() || Modifier.isAbstract(cls.getModifiers())){
            throw new IllegalArgumentException();
        }
        else {
            int i = choose_constructor(cls, cls.getSimpleName() + " " + name);
            Object[] params = Arrays.stream(rf.getConstructorParams(cls, i)).map(p -> {
                try {
                    return newInstance(p.getType(), p.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }).toArray();
            o = rf.newInstance(cls,i,params);
            if(params.length > 0) System.out.println();
        }
        return o;
    }

    public static int choose_constructor(Class<?> cls, String s){
        System.out.println("\nConstrutores para " + s + ":");
        System.out.print(rf.getConstructors(cls));
        System.out.print("Escolha: ");
        int i = sc.nextInt();
        System.out.println();
        return i;
    }


    public static void print_list(){
        System.out.print("\nLista de objetos:\n" + rf.list());
    }

    public static void call_methods() throws InvocationTargetException, IllegalAccessException {
        print_list();
        System.out.print("Escolha: ");
        int objIndex = sc.nextInt();
        System.out.println("\nLista de métodos:");
        System.out.print(rf.getMethods(objIndex));
        System.out.print("Escolha: ");
        int methodIndex = sc.nextInt();

        Object[] params = Arrays.stream(rf.getMethodParams(objIndex, methodIndex)).map(p -> {
            try {
                return newInstance(p.getType(), p.getName());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }).toArray();

        System.out.println("\nResultado: " + rf.callMethod(objIndex, methodIndex, params).toString());
    }
}
