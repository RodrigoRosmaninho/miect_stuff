package aula13.ex3.b;

public class Teste {
    public static void main(String[] args){
        Empregado e1 = new Empregado("Rodrigo Rosmaninho", 1);
        Empregado e2 = new Empregado("Paulo Jorge Ferreira", 2);
        Empregado e3 = new Empregado("Nuno Borges de Carvalho", 3);

        Brinquedo b1 = new Brinquedo("Rubik's Code", 1);
        Brinquedo b2 = new Brinquedo("Barbie", 2);
        Brinquedo b3 = new Brinquedo("Carro tele-comandado", 3);

        ListaOfertas ofertas = new ListaOfertas();
        ofertas.add(e1, b1);
        ofertas.add(e2, b2);
        ofertas.add(e1, b3);
        System.out.println(ofertas);
        ofertas.remove(0);
        System.out.println(ofertas);
    }
}
