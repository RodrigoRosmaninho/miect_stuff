package aula11.ex3;

import java.io.Serializable;
import java.util.*;

public class Ementa implements Serializable {
    private String nome;
    private String local;
    private ArrayList<Alimento> alimentos; // Lista Ligada pedida pelo enunciado
    private ArrayList<Prato> pratos; // Lista Ligada pedida pelo enunciado
    private ArrayList<Node> ementa;

    public Ementa(String nome, String local){
        this.nome = nome;
        this.local = local;
        alimentos = new ArrayList<>();
        pratos = new ArrayList<>();
        ementa = new ArrayList<>();
    }

    private Ementa(String nome, String local, ArrayList alimentos, ArrayList pratos, ArrayList ementa) {
        this.nome = nome;
        this.local = local;
        this.alimentos = alimentos;
        this.pratos = pratos;
        this.ementa = ementa;
    }

    public int size(){
        return ementa.size();
    }

    public String getNome(){
        return nome;
    }

    public String getLocal(){
        return local;
    }

    public ArrayList<Alimento> getAlimentos() {
        return alimentos;
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }

    public ArrayList<Node> getEmenta() {
        return ementa;
    }

    public void createAlimento(Alimento a){
        alimentos.add(a);
    }

    public void createPrato(Prato p){
        pratos.add(p);
    }

    public boolean destroyPrato(int i){
        if(i <= 0 || i > pratos.size()) throw new IndexOutOfBoundsException("Índice Inválido!");
        Prato p = pratos.get(i);
        boolean contained = false;
        while(pratos.contains(p)){
            pratos.remove(p);
            contained = true;
        }
        ementa.removeIf((n) -> n.getPrato().equals(p));
        return contained;
    }

    public boolean addAlimento(int al, int pr) throws Exception{
        if(al <= 0 || al > alimentos.size()) throw new IndexOutOfBoundsException("Índice de Alimento Inválido!");
        if(pr <= 0 || pr > pratos.size()) throw new IndexOutOfBoundsException("Índice de Prato Inválido!");
        Alimento a = alimentos.get(al);
        Prato p = pratos.get(pr);
        if(p.getComposicao().contains(a)) throw new Exception("Este alimento já existe no prato em questão!");
        return p.addIngrediente(a);
    }

    public boolean removeAlimento(int al, int pr){
        Prato p = pratos.get(pr);
        if(al <= 0 || al > p.getComposicao().size()) throw new IndexOutOfBoundsException("Índice Inválido!");
        Alimento a = alimentos.get(al);
        return p.removeIngrediente(a);
    }

    public void addPrato(Prato p, DiaSemana ds){
        ementa.add(new Node(p,ds));
        Collections.sort(ementa, Comparator.comparing(Node::getDia));
    }

    public void addPrato(int pr, DiaSemana ds) throws Exception {
        if(pr <= 0 || pr > pratos.size()) throw new IndexOutOfBoundsException("Índice Inválido!");
        Prato p = pratos.get(pr);
        if(ementa.contains(new Node(p,ds))) throw new Exception("Na ementa já existe o mesmo prato no mesmo dia!");
        ementa.add(new Node(p,ds));
    }

    public boolean removePrato(int pr){
        if(pr <= 0 || pr > ementa.size()) throw new IndexOutOfBoundsException("Índice Inválido!");
        return ementa.remove(ementa.get(pr));
    }

    public ArrayList<Alimento> getAlimentosByPrato(int pr){
        if(pr <= 0 || pr > pratos.size()) throw new IndexOutOfBoundsException("Índice Inválido!");
        Prato p = pratos.get(pr);
        return p.getComposicao();
    }

    public String pratosToString(){
        String res = "";
        int i = 1;
        for(Node n : ementa) {
            res += i++ + " -> " + n.getPrato().toString() + "\n";
        }
        return res;
    }

    public String toString(){
        if(ementa.isEmpty()) throw new NullPointerException("A ementa está vazia de momento.");
        return ementa.toString();
    }

    public boolean equals(Ementa e){
        return nome.equals(e.getNome()) && local.equals(e.getLocal()) && alimentos.equals(e.getAlimentos()) && pratos.equals(e.getPratos()) && ementa.equals(e.getEmenta());
    }

    public int hashCode() {
        return Objects.hash(nome, local, alimentos, pratos, ementa);
    }
}