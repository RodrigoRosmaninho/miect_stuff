package aula9.ex3;

import java.util.Iterator;

public class ListaPessoas {
    private ListaLigada<Pessoa> lista;

    public ListaPessoas() {
        lista = new ListaLigada<>();
    }

    public void addPessoa(Pessoa p){
        lista.add(p);
    }

    public void removePessoa(Pessoa p){
        lista.remove(p);
    }

    public int totalPessoas(){
        return lista.getSize();
    }

    public ListaIteradora iterator(){
        return new ListaIteradora();
    }

    class ListaIteradora implements Iterator<Pessoa> {
        private Node<Pessoa> node;
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
        public Pessoa next() {
            node = node.getNext();
            index++;
            return node.getValue();
        }

        public boolean hasPrevious() {
            return index > 0;
        }

        public Pessoa previous() {
            node = node.getPrevious();
            index--;
            return node.getValue();
        }

        @Override
        public void remove() {
            lista.remove(node.getValue());
        }
    }

}
