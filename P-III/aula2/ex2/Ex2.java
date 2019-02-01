package aula2.ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex2 {
	static Sopa sopa;
	static File f;
	static Scanner scf;
	
	public static void main(String[] args) throws FileNotFoundException {
		String fname;
		if(args.length != 1) {
			System.out.print("\nIntroduza o nome do ficheiro a ler: ");
			fname = new Scanner(System.in).nextLine();
		} else fname = args[0];
		
		f = new File(fname);
		
		if(!(f.exists() && f.isFile() && f.canRead())) {
			System.out.println("\n****** Erro! É impossível ler o ficheiro indicado! ******");
			System.exit(1);
		}
		
		scf = new Scanner(f);
		String first_line = scf.nextLine();
		int size = first_line.length();
		char[][] s = new char[size][size];
		s[0] = first_line.toCharArray();
		
		for(int i = 1; i < size; i++) {
			try {
				s[i] = scf.nextLine().toCharArray();
			} catch(Exception e) {
				System.out.println("\n****** Erro! Não foi possível ler a sopa de letras apartir do ficheiro! ******");
				System.exit(2);
			}
		}
		String[] alvos = new String[0];
		while(scf.hasNextLine()) {
			try {
				String line = scf.nextLine();
				String[] lineArr;
				if(line.contains(",")) lineArr = line.split(",");
				else if(line.contains(";")) lineArr = line.split(";");
				else lineArr = line.split(" ");
				String[] tmp = new String[alvos.length + lineArr.length];
				System.arraycopy(alvos,0,tmp,0,alvos.length);
				System.arraycopy(lineArr,0,tmp,alvos.length,lineArr.length);
				alvos = tmp;
			} catch(Exception e) {
				System.out.println("\n****** Erro! Não foi possível ler as palavras a encontrar apartir do ficheiro! ******");
				System.exit(3);
			}
		}
		
		sopa = new Sopa(s, alvos);
		String[] res = sopa.start();
		for(String str : res) System.out.println(str);
	}
}
