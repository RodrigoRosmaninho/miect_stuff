package prepteste.g12e3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Agenda {
	private ArrayList<Pessoa> db;
	
	public Agenda() {
		db = new ArrayList<Pessoa>();
	}
	
	private Agenda(ArrayList<Pessoa> db) {
		this.db = db;
	}
	
	public boolean containsPessoa(int cc) {
		for(Pessoa p : db) {
			if(p.getCC() == cc) return true;
		} return false;
	}
	
	public boolean isEmpty() {
		return db.isEmpty();
	}
	
	public void addPessoa(String nome, int cc, Data data) {
		db.add(new Pessoa(nome,cc,data));
	}
	
	public boolean removePessoa(int cc) {
		for(Pessoa p : db) {
			if(p.getCC() == cc) {
				db.remove(p);
				return true;
			}
		} return false;
	}
	
	public ArrayList<Pessoa> getDB(){
		return (ArrayList<Pessoa>) db.clone();
	}
	
	public void changeOrder(int escolha) {
		switch (escolha) {
        case 1:
            Collections.sort(db, new Comparator<Pessoa>() {
                @Override
                public int compare(Pessoa p1, Pessoa p2) {
                return p1.getNome().compareTo(p2.getNome());
                }
            });
            break;
        case 2:
            Collections.sort(db, new Comparator<Pessoa>() {
                @Override
                public int compare(Pessoa p1, Pessoa p2) {
                return p1.getCC() - p2.getCC();
                }
            });
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
            break;
        case 4:
            Collections.reverse(db);
            break;
        default:
            throw new IllegalArgumentException();
        }
	}
	
	public Agenda clone() {
		return new Agenda((ArrayList<Pessoa>) db.clone());
	}
	
}
 