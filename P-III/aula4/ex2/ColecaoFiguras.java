package aula4.ex2;

import java.util.ArrayList;

public class ColecaoFiguras {
	private ArrayList<Figura> figuras;
	private double area_total;
	private double area_maxima;

	public ColecaoFiguras(double maxArea) {
		figuras = new ArrayList<Figura>();
		area_total = 0;
		area_maxima = maxArea;
	}
	
	public boolean addFigura(Figura f) {
		if(exists(f) || area_total + f.getArea() > area_maxima) return false;
		figuras.add(f);
		area_total += f.getArea();
		return true;
	}
	
	public boolean delFigura(Figura f) {
		if(!exists(f)) return false;
		figuras.remove(f);
		area_total -= f.getArea();
		return true;
	}
	
	public double areaTotal() {
		return area_total;
	}
	
	public boolean exists(Figura f) {
		return figuras.contains(f);
	}
	
	@Override
	public String toString() {
		String res = "";
		for(Figura f : figuras) {
			res += f + "\n";
		}
		return res;
	}
	
	public Figura[] getFiguras() {
		return figuras.toArray(new Figura[figuras.size()]);
	}
	
	public Ponto[] getCentros() {
		Ponto[] tmp = new Ponto[figuras.size()];
		int i = 0;
		for(Figura f : figuras) {
			tmp[i++] = f.getCentro();
		}
		return tmp;
	}
}
