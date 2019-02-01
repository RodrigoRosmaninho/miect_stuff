package aula10.ex1;

public class ListaLigada<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public ListaLigada() {
        size = 0;
    }

    public void add(T t){
        Node<T> n = new Node<>(t, last, null);

        if(last == null) first = n;
        else last.setNext(n);

        last = n;
        size++;
    }

    public boolean remove(T t){
        return remove(t, first);
    }

    private boolean remove(T t, Node<T> n){
        if(n == null) return false;
        if(n.getValue().equals(t)){
            if(!n.getValue().equals(first.getValue())) n.getPrevious().setNext(n.getNext());
            else first = n.getNext();
            n.getNext().setPrevious(n.getPrevious());
            if(n.getNext() == null) last = n;
            size--;
            return true;
        }
        return remove(t, n.getNext());
    }

    public Node<T> getFirst() {
        return first;
    }

    public int getSize() {
        return size;
    }
}

