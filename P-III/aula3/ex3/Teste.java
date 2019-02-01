package aula3.ex3;

public class Teste {
	public static void main(String[] main) {
		Condutor c1 = new Condutor("Afonso" , 12345678, new boolean[]{false,true,true,false});
		Condutor c2 = new Condutor("Ana"    , 12345679, new boolean[]{true,true,false,false});
		Condutor c3 = new Condutor("André"  , 12345688, new boolean[]{true,false,false,false});
		Condutor c4 = new Condutor("Beatriz", 12345689, new boolean[]{false,false,false,false});
		Condutor c5 = new Condutor("Dinis"  , 12345768, new boolean[]{false,true,true,true});
		Condutor c6 = new Condutor("Carla"  , 12345769, new boolean[]{true,true,false,true});
		
		Veiculo v1 = new Ligeiro(999,200,5,1000,c1);
		Veiculo v2 = new Ligeiro(996,180,7,2000,c2);
		Veiculo v3 = new Ligeiro(998,190,7,2500,c3);
		System.out.println("Ligeiro v1 -> " + v1 + "\nLigeiro v2 -> " + v2 + "\nLigeiro v3 -> " + v3 + "\n");
		
		Veiculo v4 = new Motociclo(150,180,2,150,c2);
		Veiculo v5 = new Motociclo(150,180,2,150,c6);
		Veiculo v6 = new Motociclo(150,180,2,150,c4);
		System.out.println("Motociclo v4 -> " + v4 + "\nMotociclo v5 -> " + v5 + "\nMotociclo v6 -> " + v6 + "\n");
		
		Veiculo v7 = new PesadoMercadorias(998,500,2,150,c1);
		Veiculo v8 = new PesadoMercadorias(999,620,2,150,c5);
		Veiculo v9 = new PesadoMercadorias(996,490,2,150,c6);
		System.out.println("Pesado de Mercadorias v7 -> " + v7 + "\nPesado de Mercadorias v8 -> " + v8 + "\nPesado de Mercadorias v9 -> " + v9 + "\n");

		Veiculo v10 = new PesadoPassageiros(150,180,2,150,c5);
		Veiculo v11 = new PesadoPassageiros(150,180,2,150,c6);
		Veiculo v12 = new PesadoPassageiros(150,180,2,150,c3);
		System.out.println("Pesado de Passageiros v10 -> " + v10 + "\nPesado de Passageiros v11 -> " + v11 + "\nPesado de Passageiros v12 -> " + v12 + "\n");
		
		Veiculo v13 = new Ligeiro(999,200,5,1000,c2); // igual ao v1 menos o condutor
		System.out.println("Ligeiro v13: " + v13);
		
		System.out.println("\nv1 == v2 ? -> " + v1.equals(v2));
		System.out.println("v1 == v13 ? -> " + v1.equals(v13));
	}
}
