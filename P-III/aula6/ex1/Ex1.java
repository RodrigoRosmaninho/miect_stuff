package aula6.ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex1 {
    static Scanner sc;
    static Ementa ementa;

    public static void main(String[] args) throws FileNotFoundException {
        sc = new Scanner(System.in);
        ementa = new Ementa("Semana 29/10 a 4/11", "Refeitório do Santiago - UA");
        while (true) mostrar_menu();
    }

    public static void mostrar_menu() throws FileNotFoundException {
        int escolha;
        System.out.print(""
                + "\n--------- Menu Geral ---------"
                + "\n[1] Criar Novo Ingrediente"
                + "\n[2] Listar Ingredientes"
                + "\n[3] Criar Novo Prato"
                + "\n[4] Remover Prato Existente"
                + "\n[5] Listar Pratos"
                + "\n[6] Adicionar Ingrediente a um Prato"
                + "\n[7] Remover Ingrediente de um Prato"
                + "\n[8] Adicionar Prato à Ementa"
                + "\n[9] Remover Prato da Ementa"
                + "\n[10] Imprimir Ementa"
                + "\n[11] Carregar Ementa de um ficheiro"
                + "\n[12] Salvar Ementa num ficheiro"
                + "\n[13] Terminar Programa"
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
                create_alimento();
                break;
            case 2:
                print_alimentos();
                break;
            case 3:
                create_prato();
                break;
            case 4:
                destroy_prato();
                break;
            case 5:
                print_pratos();
                break;
            case 6:
                add_alimento();
                break;
            case 7:
                remove_alimento();
                break;
            case 8:
                add_prato();
                break;
            case 9:
                remove_prato();
                break;
            case 10:
                print_ementa();
                break;
            case 11:
                quick_load();
                break;
            case 12:
                quick_save();
                break;
            case 13:
                System.out.println(); // newline
                System.exit(0);
            default:
                System.out.println("\n****** Erro! Introduziu uma opção inválida! ******");

        }
    }

    public static void create_alimento(){
        String nome;
        double proteinas, calorias, peso;

        try {
            System.out.print("\nProteínas por 100g: ");
            proteinas = sc.nextDouble();
            sc.nextLine();

            System.out.print("Calorias por 100g: ");
            calorias = sc.nextDouble();
            sc.nextLine();

            System.out.print("Peso do alimento: ");
            peso = sc.nextDouble();
            sc.nextLine();
        }catch(InputMismatchException ime) {
            System.out.println("\n****** Erro! Apenas são aceites números inteiros/decimais positivos! ******");
            sc.nextLine();
            return;
        }

        int escolha;
        System.out.print(""
                + "\n--- Tipo de Alimento ---"
                + "\n[1] Carne"
                + "\n[2] Peixe"
                + "\n[3] Cereal (Vegetariano)"
                + "\n[4] Legume (Vegetariano)"
                + "\nIntroduza o tipo de alimento: ");
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
                System.out.print(""
                        + "\n--- Variedade de Carne ---"
                        + "\n[1] Vaca"
                        + "\n[2] Porco"
                        + "\n[3] Peru"
                        + "\n[4] Frango"
                        + "\n[5] Outra"
                        + "\nIntroduza a variedade da carne: ");
                try {
                    escolha = sc.nextInt();
                    if (escolha < 1 || escolha > 5) throw new InputMismatchException();
                } catch (InputMismatchException ime) {
                    System.out.println("\n****** Erro! Introduziu uma opção inválida! ******");
                    sc.nextLine();
                    return;
                }
                sc.nextLine();
                try {
                    ementa.createAlimento(new Carne(Carne.Variedade.values()[escolha - 1], proteinas, calorias, peso));
                } catch (Exception e) {
                    System.out.println("\n****** Erro! " + e.getMessage() + " ******");
                    return;
                }
                break;
            case 2:
                System.out.print(""
                        + "\n--- Tipo de Peixe ---"
                        + "\n[1] Congelado"
                        + "\n[2] Fresco"
                        + "\nIntroduza o tipo de peixe: ");
                try {
                    escolha = sc.nextInt();
                    if (escolha < 1 || escolha > 2) throw new InputMismatchException();
                } catch (InputMismatchException ime) {
                    System.out.println("\n****** Erro! Introduziu uma opção inválida! ******");
                    sc.nextLine();
                    return;
                }
                sc.nextLine();
                try {
                    ementa.createAlimento(new Peixe(Peixe.Tipo.values()[escolha - 1], proteinas, calorias, peso));
                } catch (Exception e) {
                    System.out.println("\n****** Erro! " + e.getMessage() + " ******");
                    return;
                }
                break;
            case 3:
                System.out.print("\nNome do Cereal: ");
                nome = sc.nextLine();
                try {
                    ementa.createAlimento(new Cereal(nome, proteinas, calorias, peso));
                } catch (Exception e) {
                    System.out.println("\n****** Erro! " + e.getMessage() + " ******");
                    return;
                }
                break;
            case 4:
                System.out.print("\nNome do Legume: ");
                nome = sc.nextLine();
                try{
                    ementa.createAlimento(new Legume(nome, proteinas, calorias, peso));
                }catch (Exception e) {
                    System.out.println("\n****** Erro! " + e.getMessage() + " ******");
                    return;
                }
                break;
            default:
                System.out.println("\n****** Erro! Introduziu uma opção inválida! ******");
                break;
        }
    }

    public static void create_prato(){
        System.out.print("\nNome do Prato: ");
        String nome = sc.nextLine();

        int escolha;
        System.out.print(""
                + "\n--- Tipo de Prato ---"
                + "\n[1] Prato Normal"
                + "\n[2] Prato Vegetariano"
                + "\n[3] Prato Dieta"
                + "\nIntroduza o tipo de prato: ");
        try {
            escolha = sc.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("\n****** Erro! Introduziu uma opção inválida! ******");
            sc.nextLine();
            return;
        }
        sc.nextLine();

        switch (escolha){
            case 1:
                try {
                    ementa.createPrato(new Prato(nome));
                } catch (Exception e) {
                    System.out.println("\n****** Erro! " + e.getMessage() + " ******");
                    return;
                }
                break;
            case 2:
                try{
                    ementa.createPrato(new PratoVegetariano(nome));
                }catch (Exception e) {
                    System.out.println("\n****** Erro! " + e.getMessage() + " ******");
                    return;
                }
                break;
            case 3:
                double limite;
                try {
                    System.out.print("\nLimite de Calorias: ");
                    limite = sc.nextDouble();
                    sc.nextLine();
                }catch(InputMismatchException ime) {
                    System.out.println("\n****** Erro! Apenas são aceites números inteiros/decimais positivos! ******");
                    sc.nextLine();
                    return;
                }
                try {
                    ementa.createPrato(new PratoDieta(nome, limite));
                }catch (Exception e) {
                    System.out.println("\n****** Erro! " + e.getMessage() + " ******");
                    return;
                }
                break;
            default:
                System.out.println("\n****** Erro! Introduziu uma opção inválida! ******");
                break;
        }
    }

    public static void destroy_prato(){
        try {
            print_pratos();
            System.out.print("\nPrato a Remover (índice): ");
            int escolha = sc.nextInt();
            sc.nextLine();
            ementa.destroyPrato(escolha);
        }catch(InputMismatchException ime) {
            System.out.println("\n****** Erro! Índice Inválido! ******");
            sc.nextLine();
            return;
        }catch (Exception e) {
            System.out.println("\n****** Erro! " + e.getMessage() + " ******");
            return;
        }
    }

    public  static  void add_alimento(){
        if(ementa.getPratos().size() == 0){
            System.out.println("\nNão existem pratos de momento.");
            return;
        }
        if(ementa.getAlimentos().size() == 0){
            System.out.println("\nNão existem alimentos de momento.");
            return;
        }
        try {
            print_alimentos();
            System.out.print("\nAlimento a adicionar (índice): ");
            int alimento = sc.nextInt();
            sc.nextLine();

            print_pratos();
            System.out.print("\nPrato destino (índice): ");
            int prato = sc.nextInt();
            sc.nextLine();
            if (!ementa.addAlimento(alimento, prato)) {
                if(ementa.getPratos().getObjFromIndex(prato) instanceof PratoDieta) throw new Exception("Limite de calorias excedido neste Prato Dieta!");
                else throw new Exception("Apenas se podem adicionar Alimentos Vegetarianos a este Prato Vegetariano!");
            }
        }catch(InputMismatchException ime) {
            System.out.println("\n****** Erro! Índice Inválido! ******");
            sc.nextLine();
            return;
        }catch (Exception e) {
            System.out.println("\n****** Erro! " + e.getMessage() + " ******");
            return;
        }
    }

    public  static  void remove_alimento(){
        if(ementa.getPratos().size() == 0){
            System.out.println("\nNão existem pratos de momento.");
            return;
        }
        if(ementa.getAlimentos().size() == 0){
            System.out.println("\nNão existem alimentos de momento.");
            return;
        }
        try {
            print_pratos();
            System.out.print("\nPrato origem (índice): ");
            int prato = sc.nextInt();
            sc.nextLine();

            System.out.println("\n-------------- Lista de Alimentos --------------");
            System.out.println(ementa.getAlimentosByPrato(prato));
            System.out.print("\nAlimento a remover (índice): ");
            int alimento = sc.nextInt();
            sc.nextLine();


            ementa.removeAlimento(alimento, prato);
        }catch(InputMismatchException ime) {
            System.out.println("\n****** Erro! Índice Inválido! ******");
            sc.nextLine();
            return;
        }catch (Exception e) {
            System.out.println("\n****** Erro! " + e.getMessage() + " ******");
            return;
        }

    }

    public static void add_prato(){
        if(ementa.getPratos().size() == 0){
            System.out.println("\nNão existem pratos de momento.");
            return;
        }
        try {
            print_pratos();
            System.out.print("\nPrato a adiconar (índice): ");
            int prato = sc.nextInt();
            sc.nextLine();
            System.out.print(""
                    + "\n--- Dia da Semana ---"
                    + "\n[1] Segunda-Feira"
                    + "\n[2] Terça-Feira"
                    + "\n[3] Quarta-Feira"
                    + "\n[4] Quinta-Feira"
                    + "\n[5] Sexta-Feira"
                    + "\n[6] Sabado"
                    + "\n[7] Domingo"
                    + "\nIntroduza o dia da semana: ");
            int dia = sc.nextInt();
            if(dia <= 0 || dia > 7) throw new Exception("Opção Inválida!");
            sc.nextLine();
            ementa.addPrato(prato, DiaSemana.values()[dia - 1]);
        }catch(InputMismatchException ime) {
            System.out.println("\n****** Erro! Índice Inválido! ******");
            sc.nextLine();
            return;
        }catch (Exception e) {
            System.out.println("\n****** Erro! " + e.getMessage() + " ******");
            return;
        }
    }

    public  static  void remove_prato(){
        if(ementa.getPratos().size() == 0){
            System.out.println("\nNão existem pratos de momento.");
            return;
        }
        if(ementa.size() == 0){
            System.out.println("\nA ementa está vazia neste momento.");
            return;
        }
        try {
            System.out.println("\n-------------- Lista de Pratos --------------");
            System.out.println(ementa.pratosToString());
            System.out.print("\nPrato a remover (índice): ");
            int prato = sc.nextInt();
            sc.nextLine();

            ementa.removePrato(prato);
        }catch(InputMismatchException ime) {
            System.out.println("\n****** Erro! Índice Inválido! ******");
            sc.nextLine();
            return;
        }catch (Exception e) {
            System.out.println("\n****** Erro! " + e.getMessage() + " ******");
            return;
        }

    }

    public static void print_pratos() {
        if(ementa.getPratos().size() == 0){
            System.out.println("\nNão existem pratos de momento.");
            return;
        }
        System.out.println("\n-------------- Lista de Pratos --------------");
        System.out.println(ementa.getPratos());
    }

    public static void print_alimentos() {
        if(ementa.getAlimentos().size() == 0){
            System.out.println("\nNão existem alimentos de momento.");
            return;
        }
        System.out.println("\n-------------- Lista de Alimentos --------------");
        System.out.println(ementa.getAlimentos());
    }

    public static void print_ementa() {
        if(ementa.size() == 0){
            System.out.println("\nA ementa está vazia neste momento.");
            return;
        }
        System.out.println("\n-------------- Ementa --------------");
        System.out.println(ementa);
    }

    public static File getFicheiro() {
        String res = "";
        do {
            System.out.print("\nIndique o nome do ficheiro: ");
            res = sc.nextLine();
        } while(res.length() == 0);
        return new File(res);
    }

    public static void quick_load() {
        try {
            ementa = Ficheiro.load(getFicheiro());
        } catch(Exception e) {
            System.out.println("\n****** Erro! Ficheiro mal formatado! ******");
            return;
        }
        System.out.println("\nOperação efetuada com sucesso!");
    }

    public static void quick_save() {
        try {
            Ficheiro.save(getFicheiro(), ementa);
            int i = 0;
        } catch(Exception e) {
            System.out.println("\n****** Erro! Não foi possível gravar o ficheiro! ******");
            return;
        }
        System.out.println("\nOperação efetuada com sucesso!");
    }
}
