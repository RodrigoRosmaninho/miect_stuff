package aula10.ex1;

import java.util.Iterator;

public class VetorGeneric<T> {
    private VetorDinamico<T> vetor;

    public VetorGeneric() {
        vetor = new VetorDinamico();
    }

    public boolean addElem(T t){
        vetor.add(t);
        return true;
    }

    public boolean removeElem(T t){
        return vetor.remove(t);
    }

    public int totalElem(){
        return vetor.size();
    }

    public Iterator iterator(){
        return new VetorIterador();
    }

    class VetorIterador implements Iterator<T> {
        private int index;

        public VetorIterador() {
            index = -1;
        }

        @Override
        public boolean hasNext() {
            return index < vetor.size() - 1;
        }

        @Override
        public T next() {
            return vetor.get(++index);
        }

        @Override
        public void remove() {
            vetor.remove(index);
        }
    }
}
