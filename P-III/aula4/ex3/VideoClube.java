package aula4.ex3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class VideoClube {
	private int quota;
	private HashMap<Integer, Cliente> clientes;
    private ArrayList<Video> catalogo;
    private ArrayList<Requisicao> reqs;
    private int SID_atual, VID_atual;
	
    public VideoClube(int N) {
    	clientes = new HashMap<Integer, Cliente>();
        catalogo = new ArrayList<Video>();
        reqs = new ArrayList<Requisicao>();
        SID_atual = 0;
        VID_atual = 0;
        quota = N;
    }
    
    public void addEstudante(Data inscricao, String nome, int cC, Data nascimento, int mEC, String curso){
    	SID_atual++;
    	clientes.put(SID_atual, new Estudante(SID_atual, inscricao, nome, cC, nascimento, mEC, curso));
    }
    
    public void addFuncionario(Data inscricao, String nome, int cC, Data nascimento, int fID, int nIF){
    	SID_atual++;
    	clientes.put(SID_atual, new Funcionario(SID_atual, inscricao, nome, cC, nascimento, fID, nIF));
    }
    
    public void removeCliente(int SID){
    	clientes.remove(SID);
    }
    
    public boolean hasCliente(int SID) {
    	return clientes.containsKey(SID);
    }
    
    public boolean clientesEmpty() {
    	return clientes.isEmpty();
    }
    
    public boolean catalogoEmpty() {
    	return catalogo.isEmpty();
    }
    
    public boolean hasClienteByCC(int CC) {
    	for(Cliente c : clientes.values()) {
    		if(c.getCC() == CC) return true;
    	}
    	return false;
    }
    
    public Cliente getCliente(int SID) {
    	return clientes.get(SID);
    }
    
    public void addVideo(String titulo, String categoria, int min_idade, int stock) {
    	VID_atual++;
    	catalogo.add(new Video(VID_atual, titulo, categoria, min_idade, stock));
    }
    
    public void removeVideo(int VID) {
    	Video v = getVideo(VID);
    	v.deleteStock();
    	catalogo.remove(v);
    }
    
    public void check_out(int SID, int VID) {
    	Cliente c = clientes.get(SID);
    	c.check_out();
    	Video v = getVideo(VID);
    	v.check_out();
    	reqs.add(new Requisicao(c, v));
    }
    
    public void check_in(int SID, int VID, double rating) {
    	Cliente c = clientes.get(SID);
    	c.check_in();
    	Video v = getVideo(VID);
    	v.check_in(rating);
    	getReq(SID, VID).check_in();
    }
    
    public Video getVideo(int VID) {
    	for(Video v : catalogo) {
    		if(v.getVID() == VID) return v;
    	}
    	return null;
    }
    
    public Requisicao getReq(int SID, int VID) {
    	for(Requisicao r : reqs) {
    		if(r.getCliente().getSID() == SID && r.getVideo().getVID() == VID && !r.is_devolvido()) return r;
    	}
    	return null;
    }
    
    public HashMap<Integer, Cliente> getClientes() {
    	return clientes;
    }
    
    public int getIdadeMinima(Cliente c) {
    	int idade = c.getNascimento().getIdade();
    	if(idade >= 18) return 5; // M18
    	if(idade >= 16) return 4; // M16
    	if(idade >= 12) return 3; // M12
    	if(idade >=  8) return 2; // M8
    	return 1; 				  // ALL
    }
    
    public ArrayList<Video> getCatalogo(Cliente c) {
    	ArrayList<Video> temp = new ArrayList<Video>();
    	for(Video v : catalogo) {
    		if(v.getMin_idade() <= getIdadeMinima(c)) temp.add(v);
    	}
    	return temp;
    }
    
    public ArrayList<Video> getCatalogoByRating(Cliente c) {
    	ArrayList<Video> temp = new ArrayList<Video>(getCatalogo(c));
    	Collections.sort(temp, new Comparator<Video>() {
            @Override
            public int compare(Video v1, Video v2) {
            	if(v1.getRating_medio() > v2.getRating_medio()) return -1;
            	if(v1.getRating_medio() < v2.getRating_medio()) return 1;
    			return 0;
            }
        });
    	return temp;
    }
    
    public ArrayList<Video> getSearch(Cliente c, String s) {
    	ArrayList<Video> temp = new ArrayList<Video>();
    	for(Video v : getCatalogo(c)) {
    		if(v.getTitulo().toLowerCase().contains(s.toLowerCase())) temp.add(v);
    	}
    	return temp;
    }
    
    public ArrayList<Video> getReqsByCliente(int SID) {
    	ArrayList<Video> temp = new ArrayList<Video>();
    	for(Requisicao r : reqs) {
    		if(r.getCliente().getSID() == SID) temp.add(r.getVideo());
    	}
    	return temp;
    }
    
    public ArrayList<Cliente> getReqsByVideo(int VID) {
    	ArrayList<Cliente> temp = new ArrayList<Cliente>();
    	for(Requisicao r : reqs) {
    		if(r.getVideo().getVID() == VID) temp.add(r.getCliente());
    	}
    	return temp;
    }
    
    public int getQuota() {
    	return quota;
    }
}
