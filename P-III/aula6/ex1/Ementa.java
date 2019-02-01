package aula6.ex1;

import java.io.Serializable;
import java.util.Objects;

public class Ementa implements Serializable {
    private String nome;
    private String local;
    private ListaLigada<Alimento> alimentos; // Lista Ligada pedida pelo enunciado
    private ListaLigada<Prato> pratos; // Lista Ligada pedida pelo enunciado
    private SortedList ementa;

    public Ementa(String nome, String local){
        this.nome = nome;
        this.local = local;
        alimentos = new ListaLigada<Alimento>();
        pratos = new ListaLigada<Prato>();
        ementa = new SortedList();
    }

    private Ementa(String nome, String local, ListaLigada<Alimento> alimentos, ListaLigada<Prato> pratos, SortedList ementa) {
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

    public ListaLigada<Alimento> getAlimentos() {
        return alimentos;
    }

    public ListaLigada<Prato> getPratos() {
        return pratos;
    }

    public SortedList getEmenta() {
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
        Prato p = pratos.getObjFromIndex(i);
        boolean contained = false;
        while(pratos.contains(p)){
            pratos.remove(p);
            contained = true;
        }
        if(contained){
            Node n = ementa.first();
            while(n != null){
                Node tmp = n.getNext();
                if(n.getPrato().equals(p)) ementa.remove(n);
                n = tmp;
            }
        }
        return contained;
    }

    public boolean addAlimento(int al, int pr) throws Exception{
        if(al <= 0 || al > alimentos.size()) throw new IndexOutOfBoundsException("Índice de Alimento Inválido!");
        if(pr <= 0 || pr > pratos.size()) throw new IndexOutOfBoundsException("Índice de Prato Inválido!");
        Alimento a = alimentos.getObjFromIndex(al);
        Prato p = pratos.getObjFromIndex(pr);
        if(p.getComposicao().contains(a)) throw new Exception("Este alimento já existe no prato em questão!");
        return p.addIngrediente(a);
    }

    public boolean removeAlimento(int al, int pr){
        Prato p = pratos.getObjFromIndex(pr);
        if(al <= 0 || al > p.getComposicao().size()) throw new IndexOutOfBoundsException("Índice Inválido!");
        Alimento a = alimentos.getObjFromIndex(al);
        return p.removeIngrediente(a);
    }

    public void addPrato(Prato p, DiaSemana ds){
        ementa.add(new Node(p,ds));
    }

    public void addPrato(int pr, DiaSemana ds) throws Exception {
        if(pr <= 0 || pr > pratos.size()) throw new IndexOutOfBoundsException("Índice Inválido!");
        Prato p = pratos.getObjFromIndex(pr);
        if(ementa.contains(new Node(p,ds))) throw new Exception("Na ementa já existe o mesmo prato no mesmo dia!");
        ementa.add(new Node(p,ds));
    }

    public boolean removePrato(int pr){
        if(pr <= 0 || pr > ementa.size()) throw new IndexOutOfBoundsException("Índice Inválido!");
        return ementa.remove(ementa.getObjFromIndex(pr));
    }

    public ListaLigada<Alimento> getAlimentosByPrato(int pr){
        if(pr <= 0 || pr > pratos.size()) throw new IndexOutOfBoundsException("Índice Inválido!");
        Prato p = pratos.getObjFromIndex(pr);
        return p.getComposicao();
    }

    public String pratosToString(){
        String res = "";
        int i = 1;
        Node n = ementa.first();
        while(n != null){
            res += i++ + " -> " + n.getPrato().toString() + "\n";
            n = n.getNext();
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