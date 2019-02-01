package aula9.ex2;

public abstract class GeladoDecorator implements Gelado{
    protected Gelado gelado;

    GeladoDecorator(Gelado gelado) {
        this.gelado = gelado;
    }

    public void base(int bolas){
        gelado.base(bolas);
    }
}
