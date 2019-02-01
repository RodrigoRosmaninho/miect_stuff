package aula9.ex2;

public class Topping extends GeladoDecorator {
    private String topping;

    Topping(Gelado gelado, String topping) {
        super(gelado);
        this.topping = topping;
    }

    @Override
    public void base(int bolas) {
        super.base(bolas);
        System.out.print(" com " + topping);
    }
}
