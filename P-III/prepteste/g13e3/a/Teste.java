package prepteste.g13e3.a;

public class Teste {
    public static void main(String[] args) {
        ListaEmpregados lista = new ListaEmpregados();
        lista.add("Rodrigo Rosmaninho");
        lista.add("Teste 1");
        System.out.println(lista);
        lista.remove(0);
        System.out.println(lista);
    }
}
