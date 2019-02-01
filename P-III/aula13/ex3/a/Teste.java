package aula13.ex3.a;

public class Teste {
    public static void main(String[] args){
        ListaEmpregados lista = new ListaEmpregados();
        lista.add("Rodrigo Rosmaninho");
        lista.add("Paulo Jorge Ferreira");
        lista.add("Nuno Borges de Carvalho");
        System.out.println(lista);
        lista.remove(0);
        System.out.println(lista);
    }
}
