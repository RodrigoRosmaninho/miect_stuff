package aula9.ex2;

public class Copo extends GeladoDecorator {
    Copo(Gelado gelado) {
        super(gelado);
    }

    @Override
    public void base(int bolas) {
        super.base(bolas);
        System.out.print(" em copo");
    }
}
