package aula4.ex2;

public class Retangulo extends Figura{
    private double comprimento;
    private double largura;
    
    public Retangulo(double comprimento, double largura) {
        setCentro(new Ponto(0,0));
    	this.comprimento = comprimento;
        this.largura = largura;
    }

    public Retangulo(double abcissa, double ordenada, double comprimento, double largura) {
        setCentro(new Ponto(abcissa,ordenada));
    	this.comprimento = comprimento;
        this.largura = largura;
    }
    
    public Retangulo(Retangulo r) {
    	setCentro(r.getCentro());
    	comprimento = r.getComprimento();
    	largura = r.getLargura();
    }
    
    public double getComprimento() {
    	return comprimento;
    }
    
    public double getLargura() {
    	return largura;
    }

    public double getArea(){
        return Math.abs(comprimento) * Math.abs(largura);
    }

    public double getPerimetro(){
        return 2 * Math.abs(comprimento) + 2 * Math.abs(largura);
    }

    @Override
    public String toString(){
        return "Retângulo de Centro " + getCentro() + ", altura " + largura + ", comprimento " + comprimento;
    }
    
    public boolean equals(Retangulo r){
        return getCentro().equals(r.getCentro()) && comprimento == r.getComprimento() && largura == r.getLargura();
    }
}
