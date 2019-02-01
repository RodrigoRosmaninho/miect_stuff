package aula1.ex3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex3 {
    static Scanner sc;

    public static void main(String[] args) {
    	int escolha;
        sc = new Scanner(System.in);
        while (true) {
            System.out.print("\nMenu:\n[1] Novo Círculo\n[2] Novo Quadrado\n[3] Novo Retângulo\n[4] Terminar Programa\nIntroduza a escolha: ");
            
            try {
                escolha = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("\n****** Erro! Introduziu uma opção inválida! ******");
                sc.nextLine();
                return;
            }
            sc.nextLine();

            switch (escolha) {
            case 1:
                System.out.print("\nCoordenadas do ponto superior esquerdo (no formato x,y): ");
                Ponto centro = getPonto(); if(centro == null) continue;
                System.out.print("Raio: ");
                double raio = sc.nextDouble();
                Circulo circulo = new Circulo(centro, raio);
                System.out.println("\nÁrea: " + circulo.getArea());
                System.out.println("Perímetro: " + circulo.getPerimetro());
                break;
            case 2:
                System.out.print("\nCoordenadas do ponto superior esquerdo (no formato x,y): ");
                Ponto sup_esq = getPonto(); if(sup_esq == null) continue;
                System.out.print("\nCoordenadas do ponto inferior direito (no formato x,y): ");
                Ponto inf_dir = getPonto(); if(inf_dir == null) continue;
                Quadrado quadrado = new Quadrado(sup_esq, inf_dir);
                System.out.println("\nÁrea: " + quadrado.getArea());
                System.out.println("Perímetro: " + quadrado.getPerimetro());
                break;
            case 3:
                System.out.print("\nCoordenadas do ponto superior esquerdo (no formato x,y): ");
                sup_esq = getPonto(); if(sup_esq == null) continue;
                System.out.print("\nCoordenadas do ponto inferior direito (no formato x,y): ");
                inf_dir = getPonto(); if(inf_dir == null) continue;
                Retangulo retangulo = new Retangulo(sup_esq, inf_dir);
                System.out.println("\nÁrea: " + retangulo.getArea());
                System.out.println("Perímetro: " + retangulo.getPerimetro());
                break;
            case 4:
            	System.out.println();
            	System.exit(0);
            default:
                System.out.println("\n****** Erro! Escolheu uma opção inválida! ******");

            }
        }
    }
    
    public static Ponto getPonto() {
    	try {
    		String[] temp = sc.nextLine().split(",");
    		if(temp.length != 2) {
    			System.out.println("\n****** Erro! Formato Inválido! ******");
        		return null;
    		}
    		return new Ponto(Double.parseDouble(temp[0]), Double.parseDouble(temp[1]));
    	} catch(NumberFormatException nfe) {
    		System.out.println("\n****** Erro! O ponto introduzido é inválido! ******");
    		return null;
    	}
    	
    }
}
