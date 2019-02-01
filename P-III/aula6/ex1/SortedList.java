package aula6.ex1;

import java.io.Serializable;

public class SortedList implements Serializable {
    private Node first = null;
    private int size = 0;

    public SortedList(){}

    public SortedList(Node first, int size){
        this.first = first;
        this.size = size;
    }

    public Node first(){
        return first;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(Node n){
        if(isEmpty()) first = n;
        else add(first,n);
        size ++;
    }

    private void add(Node atual, Node novo){
        if(atual.equals(first) && first.compareTo(novo) > 0){
            novo.setNext(first);
            first = novo;
        }
        else if(atual.getNext() == null || atual.getNext().compareTo(novo) > 0){
            novo.setNext(atual.getNext());
            atual.setNext(novo);
        }
        else add(atual.getNext(), novo);

    }

    public boolean remove(Node n){
        if(!isEmpty()){
            if(first.equals(n)) {
                first = n.getNext();
                size--;
                return true;
            }
            else if(remove(first, n)){
                size--;
                return true;
            }
        }
        return false;
    }

    private boolean remove(Node atual, Node alvo){
        if(atual.getNext().equals(alvo)) {
            atual.setNext(atual.getNext().getNext());
            return true;
        }
        else if(!atual.getNext().equals(null)) return remove(atual.getNext(), alvo);
        return false;
    }

    public boolean contains(Node alvo){
        if(size == 0) return false;
        return contains(first, alvo);
    }

    private boolean contains(Node atual, Node alvo){
        if(atual.equals(alvo)) return true;
        if(atual.getNext() != null) return contains(atual.getNext(), alvo);
        return false;
    }

    public Node getObjFromIndex(int index){
        if(index == 1) return first;
        int i = 2;
        Node n = first.getNext();
        while(n != null){
            if(i++ == index) return n;
            n = n.getNext();
        }
        throw new IndexOutOfBoundsException("Prato não encontrado na Ementa");
    }

    public String toString(){
        if(isEmpty()) throw new NullPointerException();
        String res = "";
        Node n = first;
        while(n != null) {
            res += n.toString() + "\n";
            n = n.getNext();
        }
        return res;
    }

    public boolean equals(SortedList sl){
        if(isEmpty() && sl.isEmpty()) return true;
        if(size != sl.size()) return false;
        Node n = first;
        Node m = sl.first();
        do{
            if(!n.equals(m)) return false;
            n = n.getNext();
            m = m.getNext();
        } while(n.getNext() != null);
        return true;
    }
}