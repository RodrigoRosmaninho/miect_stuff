package aula11.ex1;

import java.util.Iterator;

public class ListaGeneric<T> {
    private ListaLigada<T> lista;

    public ListaGeneric() {
        lista = new ListaLigada<>();
    }

    public void addElem(T t){
        lista.add(t);
    }

    public void removePessoa(T t){
        lista.remove(t);
    }

    public int totalElem(){
        return lista.getSize();
    }

    public Iterator iterator(){
        return new ListaIteradora();
    }

    class ListaIteradora implements Iterator<T> {
        private Node<T> node;
        private int index;

        public ListaIteradora() {
            node = new Node<>(null, null, lista.getFirst());
            index = -1;
        }

        @Override
        public boolean hasNext() {
            return index < lista.getSize() - 1;
        }

        @Override
        public T next() {
            node = node.getNext();
            index++;
            return node.getValue();
        }

        @Override
        public void remove() {
            lista.remove(node.getValue());
        }
    }

}
