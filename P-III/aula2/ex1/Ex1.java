package aula2.ex1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import aula2.ex1.Data;
import aula2.ex1.DateValidationException;

public class Ex1 {
	static Scanner sc;
	static VideoClube vc;
    

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        
        int N = 0;
        System.out.print("\nNúmero máximo de empréstimos simultâneos: ");
        do {
	    	N = getOpcao();
	    	if(N <= 0) {
	    		System.out.println("\n****** Erro! Número inválido! ******");
	    		return;
	    	}
        } while(N <= 0);
        
        vc = new VideoClube(N);
        while(true) mostrar_menu();
    }

    public static void mostrar_menu() {
        int escolha;
        System.out.print(""
                + "\n--------- Menu Geral ---------"
                + "\n[1]  Adicionar Novo Estudante"
                + "\n[2]  Adicionar Novo Funcionário"
                + "\n[3]  Remover Cliente Existente"
                + "\n[4]  Listar Clientes"
                + "\n[5]  Adicionar Novo Video"
                + "\n[6]  Remover Video Existente"
                + "\n[7]  Listar Videos"
                + "\n[8]  Listar Videos por Rating"
                + "\n[9]  Pesquisar Videos"
                + "\n[10] Ver Disponibilidade de um Vídeo"
                + "\n[11] Efetuar Empréstimo"
                + "\n[12] Efetuar Devolução"
                + "\n[13] Listar Empréstimos por Cliente"
                + "\n[14] Listar Empréstimos por Vídeo"
                + "\n[15] Terminar Programa"
                + "\nIntroduza a escolha: ");
        
        escolha = getOpcao();

        switch (escolha) {
        case 1:
            add_estudante();
            break;
        case 2:
            add_funcionario();
            break;
        case 3:
            remove_cliente();
            break;
        case 4:
        	list_clientes();
        	break;
        case 5:
            add_video();
            break;
        case 6:
            remove_video();
            break;
        case 7:
            list_videos(false); // by_rating = false
            break;
        case 8:
            list_videos(true); // by_rating = true
            break;
        case 9:
            search_video();
            break;
        case 10:
        	check_stock();
        	break;
        case 11:
            check_out();
            break;
        case 12:
            check_in();
            break;
        case 13:
            list_reqs_cliente();
            break;
        case 14:
            list_reqs_video();
            break;
        case 15:
            System.out.println(); // newline
            System.exit(0);
        default:
            System.out.println("\n****** Erro! Introduziu uma opção inválida! ******");
        }
    }
    
    public static int getOpcao() {
    	try {
            int res = sc.nextInt();
            sc.nextLine();
            return res;
        } catch (InputMismatchException ime) {
        	sc.nextLine();
            return -1;
        }
    }
    
    public static Data getData() {
    	String data = sc.nextLine();
    	String[] dataArr = data.split("-");
        if (dataArr.length == 3) {
            try {
                return new Data(Integer.parseInt(dataArr[0]), Integer.parseInt(dataArr[1]), Integer.parseInt(dataArr[2]));
            } catch (NumberFormatException nfe) {
                System.out.println("\n****** Erro! A data só pode conter algarismos e o delimitador '-'! ******");
                return null;
            }
            catch(DateValidationException dve) {
                System.out.println("\n****** Erro! A data introduzida é inválida! ******");
                return null;
            }
        } else {
            System.out.println("\n****** Erro! Formato de data não reconhecido! ******");
            return null;
        }
    }
    
    public static void add_estudante() {
    	System.out.print("\nNome: ");
    	String nome = sc.nextLine();
    	if(nome.length() == 0) {
    		System.out.println("\n****** Erro! O nome não pode estar vazio! ******");
    		return;
    	}
    	
    	System.out.print("Data de Inscrição (no formato dd-mm-aaaa): ");
    	Data data_insc = getData();
    	if(data_insc == null) return;
    	
    	System.out.print("Data de Nascimento (no formato dd-mm-aaaa): ");
    	Data data_nasc = getData();
    	if(data_nasc == null) return;
    	
    	System.out.print("Número de Cartão de Cidadão: ");
    	int cc = getOpcao();
    	if(cc <= 0) {
    		System.out.println("\n****** Erro! Número de CC inválido! ******");
    		return;
    	}
    	if(vc.hasClienteByCC(cc)) {
    		System.out.println("\n****** Erro! Já existe um cliente com esse CC! ******");
    		return;
    	}
    	
    	System.out.print("Número Mecanográfico: ");
    	int mec = getOpcao();
    	if(mec <= 0) {
    		System.out.println("\n****** Erro! Número Mecanográfico inválido! ******");
    		return;
    	}
    	
    	System.out.print("Curso: ");
    	String curso = sc.nextLine();
    	if(curso.length() == 0) {
    		System.out.println("\n****** Erro! O curso não pode estar vazio! ******");
    		return;
    	}
    	
    	vc.addEstudante(data_insc, nome, cc, data_nasc, mec, curso);
    	System.out.println("Operação efetuada com sucesso!");
    	
    }
    
    public static void add_funcionario() {
    	System.out.print("\nNome: ");
    	String nome = sc.nextLine();
    	if(nome.length() == 0) {
    		System.out.println("\n****** Erro! O nome não pode estar vazio! ******");
    		return;
    	}
    	
    	System.out.print("Data de Inscrição (no formato dd-mm-aaaa): ");
    	Data data_insc = getData();
    	if(data_insc == null) return;
    	
    	System.out.print("Data de Nascimento (no formato dd-mm-aaaa): ");
    	Data data_nasc = getData();
    	if(data_nasc == null) return;
    	
    	System.out.print("Número de Cartão de Cidadão: ");
    	int cc = getOpcao();
    	if(cc <= 0) {
    		System.out.println("\n****** Erro! Número de CC inválido! ******");
    		return;
    	}
    	if(vc.hasClienteByCC(cc)) {
    		System.out.println("\n****** Erro! Já existe um cliente com esse CC! ******");
    		return;
    	}
    	
    	System.out.print("ID de funcionário: ");
    	int fid = getOpcao();
    	if(fid <= 0) {
    		System.out.println("\n****** Erro! ID de funcionário inválido! ******");
    		return;
    	}
    	
    	System.out.print("Número de Identificação Fiscal: ");
    	int nif = getOpcao();
    	if(nif <= 0) {
    		System.out.println("\n****** Erro! NIF inválido! ******");
    		return;
    	}
    	
    	vc.addFuncionario(data_insc, nome, cc, data_nasc, fid, nif);
    	System.out.println("Operação efetuada com sucesso!");
    }
    
    public static void remove_cliente() {
    	System.out.print("\nID do Sócio a remover: ");
    	int SID = getOpcao();
    	if(SID <= 0) {
    		System.out.println("\n****** Erro! ID de Sócio inválido! ******");
    		return;
    	}
    	if(!vc.hasCliente(SID)) {
    		System.out.println("\n****** Erro! Não existe um cliente com este ID de Sócio! ******");
    		return;
    	}
    	
    	vc.removeCliente(SID);
    	System.out.println("Operação efetuada com sucesso!");
    }
    
    public static void list_clientes() {
    	if (!vc.clientesEmpty()) {
            System.out.println("\n---------------------------------- Lista de Clientes ------------------------------------");
            System.out.printf("   ID - Nome - #CC - Nascimento - Inscrição - Tipo - Nº MEC/ID Funcionário - Curso/NIF%n");
            System.out.println("-----------------------------------------------------------------------------------------");

            for (Cliente c : vc.getClientes().values()) {
                System.out.println(c);
            }

            System.out.println("");
        } else System.out.println("\nNão existem clientes na lista de momento.");
    }
    
    public static void add_video() {
    	System.out.print("\nTítulo: ");
    	String titulo = sc.nextLine();
    	if(titulo.length() == 0) {
    		System.out.println("\n****** Erro! O título não pode estar vazio! ******");
    		return;
    	}
    	
    	System.out.print("Categoria: ");
    	String cat = sc.nextLine();
    	if(cat.length() == 0) {
    		System.out.println("\n****** Erro! A categoria não pode estar vazia! ******");
    		return;
    	}
    	
    	System.out.print(""
    			+ "Classificação etária: "
    			+ "\n[1]  ALL"
                + "\n[2]  M8"
                + "\n[3]  M12"
                + "\n[4]  M16"
                + "\n[5]  M18"
                + "\nIntroduza a escolha: ");
    	int idade = getOpcao();
    	if(idade <= 0 || idade > 5) {
    		System.out.println("\n****** Erro! Seleção inválida! ******");
    		return;
    	}
    	
    	System.out.print("Número de cópias (stock): ");
    	int stock = getOpcao();
    	if(stock <= 0) {
    		System.out.println("\n****** Erro! Número de cópias inválido! ******");
    		return;
    	}
    	
    	vc.addVideo(titulo, cat, idade, stock);
    	System.out.println("Operação efetuada com sucesso!");
    }
    
    public static void remove_video() {
    	if(!vc.catalogoEmpty()) {
	    	System.out.print("\nID do Video a remover: ");
	    	int VID = getOpcao();
	    	if(VID <= 0) {
	    		System.out.println("\n****** Erro! ID do Video inválido! ******");
	    		return;
	    	}
	    	if(vc.getVideo(VID) == null) {
	    		System.out.println("\n****** Erro! Não existe um video com este ID! ******");
	    		return;
	    	}
	    	
	    	vc.removeVideo(VID);
	    	System.out.println("Operação efetuada com sucesso!");
	    	
    	} else System.out.println("\nNão existem vídeos na lista de momento.");
    }
    
    public static void list_videos(boolean by_rating) {
    	if (!vc.catalogoEmpty()) {
    		System.out.print("\nID de Sócio: ");
        	int SID = getOpcao();
        	if(SID <= 0) {
        		System.out.println("\n****** Erro! ID de Sócio inválido! ******");
        		return;
        	}
        	if(!vc.hasCliente(SID)) {
        		System.out.println("\n****** Erro! Não existe um cliente com este ID! ******");
        		return;
        	}
        	
        	ArrayList<Video> catalogo;
        	if(by_rating) catalogo = vc.getCatalogoByRating(vc.getCliente(SID));
        	else catalogo = vc.getCatalogo(vc.getCliente(SID));
        		
        	if(!catalogo.isEmpty()) {
	            System.out.println("\n-------------------- Lista de Vídeos para o Cliente #" + SID + " ---------------------");
	            System.out.printf("   ID - Título - Categoria - Rating Médio - Estado - Classificação Etária%n");
	            System.out.println("----------------------------------------------------------------------------");
	
	            for (Video v : catalogo) {
	                System.out.println(v);
	            }
        	} else System.out.println("\nNão existem vídeos adequados a este cliente.");

            System.out.println("");
        } else System.out.println("\nNão existem vídeos na lista de momento.");
    }
    
    public static void search_video() {
    	if (!vc.catalogoEmpty()) {
    		System.out.print("\nID de Sócio: ");
        	int SID = getOpcao();
        	if(SID <= 0) {
        		System.out.println("\n****** Erro! ID de Sócio inválido! ******");
        		return;
        	}
        	if(!vc.hasCliente(SID)) {
        		System.out.println("\n****** Erro! Não existe um cliente com este ID! ******");
        		return;
        	}
        	
        	System.out.print("Título (ou parte dele) a procurar: ");
        	String titulo = sc.nextLine();
        	if(titulo.length() == 0) {
        		System.out.println("\n****** Erro! O título não pode estar vazio! ******");
        		return;
        	}
        	
        	ArrayList<Video> catalogo = vc.getSearch(vc.getCliente(SID), titulo);
        		
        	if(!catalogo.isEmpty()) {
        		System.out.println("\n-------------------- Lista de Vídeos para o Cliente #" + SID + " ---------------------");
	            System.out.printf("   ID - Título - Categoria - Rating Médio - Estado - Classificação Etária%n");
	            System.out.println("----------------------------------------------------------------------------");
	
	            for (Video v : catalogo) {
	                System.out.println(v);
	            }
        	} else System.out.println("\nNão existem vídeos com os parametros indicados.");

            System.out.println("");
        } else System.out.println("\nNão existem vídeos na lista de momento.");
    }
    
    public static void check_stock() {
    	if(!vc.catalogoEmpty()) {
	    	System.out.print("\nID do Vídeo: ");
	    	int VID = getOpcao();
	    	if(VID <= 0) {
	    		System.out.println("\n****** Erro! ID de Vídeo inválido! ******");
	    		return;
	    	}
	    	Video v = vc.getVideo(VID);
	    	if(v == null) {
	    		System.out.println("\n****** Erro! Não existe um vídeo com este ID! ******");
	    		return;
	    	}
	    	
	    	if(v.disponivel()) System.out.println("\nO vídeo #" + VID + " tem " + v.getStock() + " cópia(s) disponíveis para empréstimo.");
	    	else System.out.println("\nO vídeo #" + VID + " não se encontra disponível para empréstimo.");
	    	
    	} else System.out.println("\nNão existem vídeos na lista de momento.");
    }
    
    public static void check_out() {
    	if(!vc.catalogoEmpty()) {
    		System.out.print("\nID de Sócio: ");
        	int SID = getOpcao();
        	if(SID <= 0) {
        		System.out.println("\n****** Erro! ID de Sócio inválido! ******");
        		return;
        	}
        	if(!vc.hasCliente(SID)) {
        		System.out.println("\n****** Erro! Não existe um cliente com este ID! ******");
        		return;
        	}
        	
        	if(vc.getCliente(SID).getNum_reqs() > vc.getQuota()) {
        		System.out.println("\nO utilizador esgotou o número de empréstimos simultâneos!");
        		return;
        	}
        	
        	System.out.print("ID do Vídeo: ");
        	int VID = getOpcao();
        	if(VID <= 0) {
        		System.out.println("\n****** Erro! ID de Vídeo inválido! ******");
        		return;
        	}
        	
        	Video v = vc.getVideo(VID);
        	if(v == null) {
        		System.out.println("\n****** Erro! Não existe um vídeo com este ID! ******");
        		return;
        	}
        	if(!v.disponivel()) {
        		System.out.println("\nNão há copias deste vídeo disponíveis para emprestar!");
        		return;
        	}
        	
        	vc.check_out(SID, VID);
        	System.out.println("Operação efetuada com sucesso!");
        	
    	} else System.out.println("\nNão existem vídeos na lista de momento.");
    }
    
    public static void check_in() {
    	if(!vc.catalogoEmpty()) {
    		System.out.print("\nID de Sócio: ");
        	int SID = getOpcao();
        	if(SID <= 0) {
        		System.out.println("\n****** Erro! ID de Sócio inválido! ******");
        		return;
        	}
        	if(!vc.hasCliente(SID)) {
        		System.out.println("\n****** Erro! Não existe um cliente com este ID! ******");
        		return;
        	}
        	
        	System.out.print("ID do Vídeo: ");
        	int VID = getOpcao();
        	if(VID <= 0) {
        		System.out.println("\n****** Erro! ID de Vídeo inválido! ******");
        		return;
        	}
        	if(vc.getVideo(VID) == null) {
        		System.out.println("\n****** Erro! Não existe um vídeo com este ID! ******");
        		return;
        	}
        	
        	if(vc.getReq(SID, VID) == null) {
        		System.out.println("\nO vídeo não foi emprestado ao cliente, logo não pode ser devolvido!");
        		return;
        	}
        	
        	double rating;
        	try {
        		System.out.print("Rating (1 a 10): ");
                rating = sc.nextDouble();
                sc.nextLine();
            } catch (InputMismatchException ime) {
            	sc.nextLine();
            	System.out.println("\n****** Erro! Rating inválido! ******");
        		return;
            }
        	
        	if(rating > 10 || rating < 1) {
        		System.out.println("\n****** Erro! Rating inválido! ******");
        		return;
        	}
        	
        	vc.check_in(SID, VID, rating);
        	System.out.println("Operação efetuada com sucesso!");
        	
    	} else System.out.println("\nNão existem vídeos na lista de momento.");
    }
    
    public static void list_reqs_cliente() {
		System.out.print("\nID de Sócio: ");
    	int SID = getOpcao();
    	if(SID <= 0) {
    		System.out.println("\n****** Erro! ID de Sócio inválido! ******");
    		return;
    	}
    	if(!vc.hasCliente(SID)) {
    		System.out.println("\n****** Erro! Não existe um cliente com este ID! ******");
    		return;
    	}
    	
    	ArrayList<Video> catalogo = vc.getReqsByCliente(SID);
    		
    	if(!catalogo.isEmpty()) {
            System.out.println("\n-------------- Lista de Vídeos requisitados pelo Cliente #" + SID + " ----------------");
            System.out.printf("   ID - Título - Categoria - Rating Médio - Estado - Classificação Etária%n");
            System.out.println("----------------------------------------------------------------------------");

            for (Video v : catalogo) {
                System.out.println(v);
            }
    	} else System.out.println("\nO cliente não requisitou vídeos!");

    }
    
    public static void list_reqs_video() {
    	if(!vc.catalogoEmpty()) {
			System.out.print("\nID do Video: ");
	    	int VID = getOpcao();
	    	if(VID <= 0) {
	    		System.out.println("\n****** Erro! ID do Vídeo inválido! ******");
	    		return;
	    	}
	    	if(vc.getVideo(VID) == null) {
	    		System.out.println("\n****** Erro! Não existe um vídeo com este ID! ******");
	    		return;
	    	}
	    	
	    	ArrayList<Cliente> clientes = vc.getReqsByVideo(VID);
	    		
	    	if(!clientes.isEmpty()) {
	    		System.out.println("\n-------------------- Lista de Clientes que requisitaram o Vídeo #" + VID + " ----------------------");
	    		System.out.printf("   ID - Nome - #CC - Nascimento - Inscrição - Tipo - Nº MEC/ID Funcionário - Curso/NIF%n");
	            System.out.println("-----------------------------------------------------------------------------------------");
	
	            for (Cliente c : clientes) {
	                System.out.println(c);
	            }
	    	} else System.out.println("\nO vídeo não foi requisitado!");
	
	        System.out.println("");
    	} else System.out.println("\nNão existem vídeos na lista de momento.");
    }

}
