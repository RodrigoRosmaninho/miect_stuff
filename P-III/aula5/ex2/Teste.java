package aula5.ex2;

import aula5.ex1.UtilCompare;

public class Teste {

	public static void main(String[] args) {
		Veiculo[] lista = {
				new Automovel(2004, "Branco", 250, 180, 7, 50, 1499, "13-BS-56"),
				new Moto(2008, "Preto", 230, 170, 8, 55, 1299, "07-QO-32"),
				new Bicicleta(1998, "Preto", 50),
				new CarroPolicia(2017, "Preto", 230, 200, 8, 55, 1299, "07-QO-32", Policia.Tipo.INEM, "h788jsb2"),
				new MotoPolicia(2009, "Preto", 230, 170, 8, 55, 1299, "07-QO-32", Policia.Tipo.PJ, "99yg86ko"),
				new BicicletaPolicia(2001, "Preto", 50, Policia.Tipo.GNR, "1jk387u6"),
		};
		
		System.out.println("Lista de Veículos: ");
		for(Veiculo v : lista) {
			System.out.println(v);
		}
		
		System.out.println("\nLista de Veículos ordenada por ano: ");
		UtilCompare.sortArray(lista);
		for(Veiculo v : lista) {
			System.out.println(v);
		}

	}

}
