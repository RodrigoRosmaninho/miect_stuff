package prepteste.g13e3.b;

public class Teste {
    public static void main(String[] args) {
        ListaOfertas lista = new ListaOfertas();
        Empregado a = new Empregado("Rodrigo Rosmaninho", 1);
        Empregado b = new Empregado("Teste Um", 2);
        Brinquedo b1 = new Brinquedo("Rubik's Cube");
        Brinquedo b2 = new Brinquedo("Balão");
        Brinquedo b3 = new Brinquedo("GameBoy");
        lista.add(new Oferta(a,b1));
        lista.add(new Oferta(a,b3));
        lista.add(new Oferta(b,b2));

        System.out.println(lista);
        lista.remove(0);
        System.out.println(lista);
    }
}
