package aula1.ex2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;

public class Ex2 {
    static Scanner sc;
    static ArrayList<Pessoa> db;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        db = new ArrayList<Pessoa>();
        while (true) mostrar_menu();
    }

    public static void mostrar_menu() {
        int escolha;
        System.out.print(""
                + "\n--------- Menu Geral ---------"
                + "\n[1] Adicionar Nova Pessoa"
                + "\n[2] Remover Pessoa Existente"
                + "\n[3] Imprimir Lista"
                + "\n[4] Alterar Ordem da Lista"
                + "\n[5] Terminar Programa"
                + "\nIntroduza a escolha: ");
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
            add_pessoa();
            break;
        case 2:
            remove_pessoa();
            break;
        case 3:
            print_lista();
            break;
        case 4:
            change_ordem();
            break;
        case 5:
            System.out.println(); // newline
            System.exit(0);
        default:
            System.out.println("\n****** Erro! Introduziu uma opção inválida! ******");

        }
    }

    public static void add_pessoa() {
        int cc;
        System.out.print("\nNome da Pessoa: ");
        String nome = sc.nextLine();
        if (nome.equals("")) {
            System.out.println("****** Erro! O nome não foi preenchido! ******");
        }
        System.out.print("Número do Cartão de Cidadão: ");
        try {
            cc = sc.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("\n****** Erro! O número do cartão de cidadão só pode conter algarismos! ******");
            sc.nextLine();
            return;
        }
        sc.nextLine();
        if (pessoa_existe(cc)) {
            System.out.println("\n****** Erro! Este cartão de cidadão já existe na lista! ******");
            return;
        }
        System.out.print("Data de Nascimento (no formato dd-mm-aaaa): ");
        String data = sc.nextLine();
        String[] dataArr = data.split("-");
        if (dataArr.length == 3) {
            try {
                db.add(new Pessoa(nome, cc, new Data(Integer.parseInt(dataArr[0]), Integer.parseInt(dataArr[1]), Integer.parseInt(dataArr[2]))));
            } catch (NumberFormatException nfe) {
                System.out.println("\n****** Erro! A data só pode conter algarismos e o delimitador '-'! ******");
                return;
            }
            catch(DateValidationException dve) {
                System.out.println("\n****** Erro! A data introduzida é inválida! ******");
            }
        } else {
            System.out.println("****** Erro! Formato de data não reconhecido! ******");
        }

    }

    public static boolean pessoa_existe(int cc) {
        for (Pessoa p : db) {
            if (p.getCC() == cc) return true;
        }
        return false;
    }

    public static void remove_pessoa() {
        if (!db.isEmpty()) {
            System.out.print("\nIndique o número do cartão de cidadão da pessoa a remover: ");
            int cc = sc.nextInt();
            boolean encontrada = false;
            for (Pessoa p : db.toArray(new Pessoa[0])) {
                if (p.getCC() == cc) {
                    db.remove(p);
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada) {
                System.out.println("\n****** Erro! Nenhuma pessoa com esse cartão foi encontrada! ******");
            }
        } else System.out.println("\nNão existem pessoas na lista de momento.");
    }

    public static void print_lista() {
        if (!db.isEmpty()) {
            System.out.println("\n-------------- Lista de Pessoas --------------");
            System.out.printf("   Nome - Numero do CC - Data de Nascimento%n");
            System.out.println("----------------------------------------------");

            for (Pessoa p : db) {
                System.out.println(p);
            }

            System.out.println("");
        } else System.out.println("\nNão existem pessoas na lista de momento.");
    }

    public static void change_ordem(){
        if (!db.isEmpty()) {
            int escolha;
            System.out.print(""
                    + "\n--- Alterar a Ordem ---"
                    + "\n[1] Ordenar por Nome"
                    + "\n[2] Ordenar por Número do CC"
                    + "\n[3] Ordenar por Data de Nascimento"
                    + "\n[4] Inverter Ordem"
                    + "\n[5] Cancelar"
                    + "\nIntroduza a escolha: ");
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
                Collections.sort(db, new Comparator<Pessoa>() {
                    @Override
                    public int compare(Pessoa p1, Pessoa p2) {
                    return p1.getNome().compareTo(p2.getNome());
                    }
                });
                System.out.println("\nOrdem alterada com sucesso!");
                break;
            case 2:
                Collections.sort(db, new Comparator<Pessoa>() {
                    @Override
                    public int compare(Pessoa p1, Pessoa p2) {
                    return p1.getCC() - p2.getCC();
                    }
                });
                System.out.println("\nOrdem alterada com sucesso!");
                break;
            case 3:
                Collections.sort(db, new Comparator<Pessoa>() {
                    @Override
                    public int compare(Pessoa p1, Pessoa p2) {
                        if(p1.getDataNasc().getAno() != p2.getDataNasc().getAno()) return p1.getDataNasc().getAno() - p2.getDataNasc().getAno();
                        if(p1.getDataNasc().getMes() != p2.getDataNasc().getMes()) return p1.getDataNasc().getMes() - p2.getDataNasc().getMes();
                        return p1.getDataNasc().getDia() - p2.getDataNasc().getDia();
                    }
                });
                System.out.println("\nOrdem alterada com sucesso!");
                break;
            case 4:
                Collections.reverse(db);
                System.out.println("\nOrdem alterada com sucesso!");
                break;
            case 5:
                return;
            default:
                System.out.println("\n****** Erro! Introduziu uma opção inválida! ******");

            }
        } else System.out.println("\nNão existem pessoas na lista de momento.");
    }

}
