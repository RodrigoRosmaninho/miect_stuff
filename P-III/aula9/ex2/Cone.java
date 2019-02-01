package aula9.ex2;

public class Cone extends GeladoDecorator {
    Cone(Gelado gelado) {
        super(gelado);
    }

    @Override
    public void base(int bolas) {
        super.base(bolas);
        System.out.print(" em cone");
    }
}
